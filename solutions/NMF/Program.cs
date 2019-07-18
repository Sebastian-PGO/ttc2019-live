using NMF.Models;
using NMF.Models.Changes;
using NMF.Models.Repository;
using System;
using System.Diagnostics;
using System.IO;
using TTC2019.LiveContest.Metamodels.Bibtex;
using TTC2019.LiveContest.Metamodels.Docbook;

[assembly: ModelMetadata("https://www.transformation-tool-contest.eu/2019/bibtex", "TTC2019.LiveContest.BibTeX.nmeta")]
[assembly: ModelMetadata("https://www.transformation-tool-contest.eu/2019/docbook", "TTC2019.LiveContest.DocBook.nmeta")]

namespace TTC2019.LiveContest
{
    class Program
    {
        private static string runIndex;
        private static string tool;
        private static int mutant;
        private static string mutantSet;
        private static string sourcePath;
        private static Stopwatch stopwatch = new Stopwatch();
        private static string mutantPath;

        static void Main(string[] args)
        {
            stopwatch.Start();
            runIndex = Environment.GetEnvironmentVariable("RunIndex");
            tool = Environment.GetEnvironmentVariable("Tool");
            sourcePath = Environment.GetEnvironmentVariable("SourcePath");
            mutantSet = Environment.GetEnvironmentVariable("MutantSet");
            mutant = int.Parse(Environment.GetEnvironmentVariable("Mutant"));
            mutantPath = Environment.GetEnvironmentVariable("MutantPath");

            var model = Path.GetFileNameWithoutExtension(sourcePath);
            var incremental = args.Length > 0 && args[0] == "incremental";

            var repository = new ModelRepository();
            // NMeta changes have the wrong URI in this case
            MetaRepository.Instance.Models.Add(new Uri("http://nmf.codeplex.com/changes/2019live"), MetaRepository.Instance.Resolve(new Uri("http://nmf.codeplex.com/changes")).Model);
            var transformation = new BibTexToDocBookSynchronization();
            transformation.Initialize();
            Report("Initialization");

            var sourceModel = repository.Resolve(sourcePath);
            var bibTex = sourceModel.RootElements[0] as BibTeXFile;

            if (!incremental)
            {
                var mutatedModel = repository.Resolve(mutantPath);
                var docBook = mutatedModel.RootElements[0] as DocBook;
                Report("Load");

                var context = transformation.Synchronize(ref bibTex, ref docBook, NMF.Synchronizations.SynchronizationDirection.CheckOnly, NMF.Transformations.ChangePropagationMode.None);
                Report("Run", context.Inconsistencies.Count);
            }
            else
            {
                var initialTarget = repository.Resolve(Path.ChangeExtension(sourcePath, "docbook"));
                var initialDocBook = initialTarget.RootElements[0] as DocBook;
                var context = transformation.Synchronize(ref bibTex, ref initialDocBook, NMF.Synchronizations.SynchronizationDirection.CheckOnly, NMF.Transformations.ChangePropagationMode.TwoWay);
                var directory = Path.GetDirectoryName(sourcePath);
                for (int i = 1; i < mutant; i++)
                {
                    var changes = repository.Resolve(Path.Combine(directory, model, $"{model}-{mutantSet}-{i}", "applied.changes"));
                    var changeSet = changes.RootElements[0] as ModelChangeSet;
                    changeSet.Apply();
                }
                Report("Load");

                var actualChanges = repository.Resolve(Path.Combine(directory, model, $"{model}-{mutantSet}-{mutant}", "applied.changes"));
                var actualChangeSet = actualChanges.RootElements[0] as ModelChangeSet;
                actualChangeSet.Apply();
                Report("Run", context.Inconsistencies.Count);
            }
        }

        private static void Report(string phase, int? problems = null)
        {
            stopwatch.Stop();
            var sourceModel = Path.GetFileName(sourcePath);
            Console.WriteLine($"{tool};{mutantSet};{sourceModel};{mutant};{runIndex};{phase};Time;{stopwatch.Elapsed.Ticks * 100}");
            Console.WriteLine($"{tool};{mutantSet};{sourceModel};{mutant};{runIndex};{phase};Memory;{Environment.WorkingSet}");
            if (problems != null)
            {
                Console.WriteLine($"{tool};{mutantSet};{sourceModel};{mutant};{runIndex};{phase};Problems;{problems.Value}");
            }
            stopwatch.Restart();
        }
    }
}
