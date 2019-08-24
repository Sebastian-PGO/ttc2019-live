package ttc2019.solutions.aof

import com.google.common.collect.HashBiMap
import java.util.function.BiConsumer
import org.eclipse.papyrus.aof.core.AOFFactory
import org.eclipse.papyrus.aof.core.IBox
import org.eclipse.papyrus.aof.core.IConstraints
import org.eclipse.papyrus.aof.core.IMetaClass
import org.eclipse.papyrus.aof.core.IOne
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver
import org.eclipse.xtend.lib.annotations.Data

class DSL {
	@Data
	static class Rule<S, T> {
		val IMetaClass<S> source
		val IMetaClass<T> target
		val String inconsistencyMessage
		val BiConsumer<S, T> binder

		val trace = HashBiMap.<S, T>create

		def forwardApply(S s) {
			trace.computeIfAbsent(s)[
				val t = target.newInstance
				binder.accept(s, t)
				t
			]
		}
		def reverseApply(T t) {
			if(inconsistencyMessage !== null) {
				throw new IllegalStateException(inconsistencyMessage)
			} else {
				trace.inverse.computeIfAbsent(t)[
					val s = source.newInstance
					// TODO: tell the binder to bind in reverse
					binder.accept(s, t)
					s
				]
			}
		}
	}

	static def <E> <=>(IBox<E> l, IBox<E> r) {
		if(l.class !== r.class) {
			println("CONVERTING")
		}
		l.bind(r.asBox(l))
	}

	static def <S, T> IBox<T> collectTo(IBox<S> it, Rule<S, T> rule) {
		collect([
			rule.forwardApply(it as S)
		])[
			rule.reverseApply(it as T)
		]
	}

	static def <E> fixed(E it, IConstraints constraints) {
		AOFFactory.INSTANCE.createBox(constraints, it).collect([
			it
		])[
			throw new IllegalArgumentException('''inconsistency: trying to change a value fixed by the transformation''')
		]
	}

// Begin additional active operations
	def <E> IOne<String> join(IBox<E> it, String sep) {
		val ret = AOFFactory.INSTANCE.createOne(
			IterableExtensions.join(it, sep)
		)

		addObserver(new DefaultObserver<E> {
			override added(int index, E element) {
				ret.set(IterableExtensions.join(it, sep))
			}
			override moved(int newIndex, int oldIndex, E element) {
				ret.set(IterableExtensions.join(it, sep))
			}
			override removed(int index, E element) {
				ret.set(IterableExtensions.join(it, sep))
			}
			override replaced(int index, E newElement, E oldElement) {
				ret.set(IterableExtensions.join(it, sep))
			}
		})
		// We would ideally need reverse propagation as well,
		// but since join is used as part of a String concatenation,
		// reverse propagation is not necessary here

		ret
	}
// End additional active operations
}