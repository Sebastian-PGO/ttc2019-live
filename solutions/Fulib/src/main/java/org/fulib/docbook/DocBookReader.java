package org.fulib.docbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocBookReader
{
   private Pattern pattern;
   public ArrayList<String> sectionTitles;
   public ArrayList<String> errorMessages;
   private DocBook docBook;
   private Paragraph searchPara = new Paragraph();

   public void readBibTex(String fileName) {
      try
      {
         List<String> lines = Files.readAllLines(Paths.get(fileName));

         ensureAllSections();

         String refList = "";
         String type;
         String title;
         String authorList = "";
         String year = "";
         String bookTitle = null;
         String journal = null;
         boolean noAuthors = false;

         for (String line : lines)
         {
            if (line.indexOf("<entries ") > 0) {
               LinkedHashMap<String, String> attrMap = getAttributes(line);
               refList = "[" + attrMap.get("id") + "] ";

               type = attrMap.get("xsi:type");
               type = type.substring("bib:".length());
               refList += type + " ";

               title = attrMap.get("title");
               refList += title + " ";
               searchPara.setContent(title);
               Paragraph ceiling = titleSection.getParas().ceiling(searchPara);
               if (ceiling == null || ceiling.getContent() == null
                     || ! ceiling.getContent().startsWith(title)) {
                  errorMessages.add("missing title: " + title);
                  new Paragraph().setContent(journal).setSection(titleSection);
               }

               authorList = "";

               year = attrMap.get("year");

               bookTitle = attrMap.get("booktitle");
               journal = attrMap.get("journal");

               noAuthors = line.endsWith("/>");
            }

            if (noAuthors || line.indexOf("</entries ") > 0) {
               refList += authorList;
               if (year != null) {
                  refList = refList.trim() + " " + year;
               }
               if (bookTitle != null) {
                  refList += " " + bookTitle;
               }
               if (journal != null) {
                  refList += " " + journal;
                  searchPara.setContent(journal);
                  Paragraph ceiling = journalSection.getParas().ceiling(searchPara);
                  if (ceiling == null || ! ceiling.getContent().startsWith(journal)) {
                     errorMessages.add("missing journal: " + journal);
                     new Paragraph().setContent(journal).setSection(journalSection);
                  }
               }
               refList = refList.trim();
               searchPara.setContent(refList);
               Paragraph ceiling = referenceSection.getParas().ceiling(searchPara);
               if (ceiling == null || ! ceiling.getContent().startsWith(refList)) {
                  errorMessages.add("missing reference: " + refList);
                  new Paragraph().setContent(journal).setSection(journalSection);
               }
            }

            if (line.indexOf("<authors ") > 0) {
               LinkedHashMap<String, String> attrMap = getAttributes(line);
               String oneAuthor = attrMap.get("author");
               authorList += oneAuthor + " ";
               searchPara.setContent(oneAuthor);
               Paragraph ceiling = authorSection.getParas().ceiling(searchPara);
               if (ceiling == null || ! ceiling.getContent().startsWith(oneAuthor)) {
                  errorMessages.add("missing author: " + oneAuthor);
                  new Paragraph().setContent(oneAuthor).setSection(authorSection);
               }
            }
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

   }

   private void ensureAllSections()
   {
      if (referenceSection == null) {
         referenceSection = new Section().setTitle("References List").setBook(docBook);
      }
      if (authorSection == null) {
         authorSection = new Section().setTitle("Authors list").setBook(docBook);
      }
      if (titleSection == null) {
         titleSection = new Section().setTitle("Titles List").setBook(docBook);
      }
      if (journalSection == null) {
         journalSection = new Section().setTitle("Journals List").setBook(docBook);
      }
   }

   public Section referenceSection = null;
   public Section authorSection = null;
   public Section titleSection = null;
   public Section journalSection = null;

   public DocBook readDocBook(String fileName) {
      docBook = new DocBook();
      sectionTitles = new ArrayList<>();
      sectionTitles.add("References List");
      sectionTitles.add("Authors list");
      sectionTitles.add("Titles List");
      sectionTitles.add("Journals List");
      errorMessages = new ArrayList<>();

      try
      {
         Section currentSection = null;
         String currentPara = "";

         List<String> lines = Files.readAllLines(Paths.get(fileName));

         pattern = Pattern.compile("\\S+=\"[^\"]+\"");
         for (String line : lines)
         {
            if (line.indexOf("<sections_1") >= 0)
            {
               // new section
               LinkedHashMap<String, String> attrMap = getAttributes(line);
               String title = attrMap.get("title");
               currentSection = createSection(docBook, title);
               if (currentSection.getTitle().startsWith("References List")) {
                  referenceSection = currentSection;
               }
               else if (currentSection.getTitle().startsWith("Authors list")) {
                  authorSection = currentSection;
               }
               else if (currentSection.getTitle().startsWith("Titles List")) {
                  titleSection = currentSection;
               }
               else if (currentSection.getTitle().startsWith("Journals List")) {
                  journalSection = currentSection;
               }
            }

            if (line.indexOf("</sections_1") >= 0) {
               currentPara = "";
            }

            if (line.indexOf("<paras") >= 0)
            {
               LinkedHashMap<String, String> attrMap = getAttributes(line);
               String content = attrMap.get("content");
               new Paragraph().setContent(content).setSection(currentSection);
               if (currentPara.compareTo(content) >= 0) {
                  errorMessages.add("sorting violated: " + content);
               }
               currentPara = content;
            }
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      return docBook;
   }


   private Section createSection(DocBook docBook, String title)
   {
      Section section = new Section().setTitle(title).setBook(docBook);

      // check section titles
      for (String sectionTitle : sectionTitles)
      {
         if (title.startsWith(sectionTitle)) {
            sectionTitles.remove(sectionTitle);
            break;
         }
      }

      return section;
   }

   private LinkedHashMap<String, String> getAttributes(String line)
   {
      Matcher matcher = pattern.matcher(line);
      int start = 0;
      LinkedHashMap<String, String> attrMap = new LinkedHashMap<>();
      while (matcher.find(start)) {
         String group = matcher.group();
         String[] split = group.split("=");
         String rightSide = split[1];
         rightSide = rightSide.substring(1, rightSide.length()-1); // chop "..."
         attrMap.put(split[0], rightSide);
         start = matcher.end();
      }
      return attrMap;
   }
}
