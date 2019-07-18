package org.fulib.docbook;

import java.io.File;

public class FulibDriver
{
   public static void main(String[] args) {
      try {
         Initialize();
         Load();
         Run();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }

   private static String Tool;
   private static String MutantSet;
   private static String SourcePath;
   private static String Mutant;
   private static String MutantPath;
   private static String RunIndex;
   private static long stopwatch;
   private static long starttime;

   private static DocBookReader docBookReader;

   static void Load()
   {
      starttime = System.nanoTime();

      docBookReader.readDocBook(MutantPath);

      stopwatch = System.nanoTime() - starttime;
      Report(BenchmarkPhase.Load, null);
   }

   static void Initialize() throws Exception
   {
      starttime = System.nanoTime();

      docBookReader = new DocBookReader();

      Tool = System.getenv("Tool");
      MutantSet = System.getenv("MutantSet");
      SourcePath = System.getenv("SourcePath");
      Mutant = System.getenv("Mutant");
      MutantPath = System.getenv("MutantPath");
      RunIndex = System.getenv("RunIndex");

      if (SourcePath == null) {
         SourcePath = "models/random10.bibtex";
         MutantPath = "models/random10/random10-double-10/mutated.docbook";
      }
      stopwatch = System.nanoTime() - starttime;
      Report(BenchmarkPhase.Initialization, null);
   }

   static void Run() throws Exception
   {
      starttime = System.nanoTime();

      docBookReader.readBibTex(SourcePath);

      int problems = docBookReader.sectionTitles.size() + docBookReader.errorMessages.size();

      stopwatch = System.nanoTime() - starttime;
      Report(BenchmarkPhase.Run, Integer.toString(problems));
   }

   static void Report(BenchmarkPhase phase, String result)
   {
      System.out.println(String.format("%s;%s;%s;%s;%s;%s;Time;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(stopwatch)));

      if ("true".equals(System.getenv("NoGC"))) {
         // nothing to do
      } else {
         Runtime.getRuntime().gc();
         Runtime.getRuntime().gc();
         Runtime.getRuntime().gc();
         Runtime.getRuntime().gc();
         Runtime.getRuntime().gc();
      }
      long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      System.out.println(String.format("%s;%s;%s;%s;%s;%s;Memory;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(memoryUsed)));

      if (result != null)
      {
         System.out.println(String.format("%s;%s;%s;%s;%s;%s;Problems;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), result));
      }
   }

   enum BenchmarkPhase {
      Initialization,
      Load,
      Run
   }
}


