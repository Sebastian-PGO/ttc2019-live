package org.fulib.docbook;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Section  implements Comparable
{

   public static final String PROPERTY_title = "title";

   private String title;

   public String getTitle()
   {
      return title;
   }

   public Section setTitle(String value)
   {
      if (value == null ? this.title != null : ! value.equals(this.title))
      {
         String oldValue = this.title;
         this.title = value;
         firePropertyChange("title", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_book = "book";

   private DocBook book = null;

   public DocBook getBook()
   {
      return this.book;
   }

   public Section setBook(DocBook value)
   {
      if (this.book != value)
      {
         DocBook oldValue = this.book;
         if (this.book != null)
         {
            this.book = null;
            oldValue.withoutSections(this);
         }
         this.book = value;
         if (value != null)
         {
            value.withSections(this);
         }
         firePropertyChange("book", oldValue, value);
      }
      return this;
   }



   public static final java.util.TreeSet<Paragraph> EMPTY_paras = new java.util.TreeSet<Paragraph>()
   { @Override public boolean add(Paragraph value){ throw new UnsupportedOperationException("No direct add! Use xy.withParas(obj)"); }};


   public static final String PROPERTY_paras = "paras";

   private java.util.TreeSet<Paragraph> paras = null;

   public java.util.TreeSet<Paragraph> getParas()
   {
      if (this.paras == null)
      {
         return EMPTY_paras;
      }

      return this.paras;
   }

   public Section withParas(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withParas(i);
            }
         }
         else if (item instanceof Paragraph)
         {
            if (this.paras == null)
            {
               this.paras = new java.util.TreeSet<Paragraph>();
            }
            if ( ! this.paras.contains(item))
            {
               this.paras.add((Paragraph)item);
               ((Paragraph)item).setSection(this);
               firePropertyChange("paras", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Section withoutParas(Object... value)
   {
      if (this.paras == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutParas(i);
            }
         }
         else if (item instanceof Paragraph)
         {
            if (this.paras.contains(item))
            {
               this.paras.remove((Paragraph)item);
               ((Paragraph)item).setSection(null);
               firePropertyChange("paras", item, null);
            }
         }
      }
      return this;
   }


   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getTitle());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setBook(null);

      this.withoutParas(this.getParas().clone());


   }


   @Override
   public int compareTo(Object o)
   {
      return this.toString().compareTo(o.toString());
   }
}