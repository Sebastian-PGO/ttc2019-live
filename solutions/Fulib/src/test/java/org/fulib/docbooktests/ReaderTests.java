package org.fulib.docbooktests;

import org.fulib.docbook.DocBook;
import org.fulib.docbook.DocBookReader;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReaderTests
{
   @Test
   public void testDocBookReader()
   {
      DocBookReader docBookReader = new DocBookReader();

      DocBook docBook = docBookReader.readDocBook("models/random10.docbook");

      assertThat(docBookReader.sectionTitles.size(), equalTo(0));

      docBookReader.readBibTex("models/random10.bibtex");

      assertThat(docBookReader.errorMessages.size(), equalTo(0));

      System.out.println(docBookReader.errorMessages);
   }


   @Test
   public void testMutatedDocBookReader()
   {
      DocBookReader docBookReader = new DocBookReader();

      DocBook docBook = docBookReader.readDocBook("models/random10/random10-double-10/mutated.docbook");

      System.out.println(docBookReader.sectionTitles);

      // assertThat(docBookReader.sectionTitles.size(), equalTo(0));

      docBookReader.readBibTex("models/random10.bibtex");

      System.out.println(docBookReader.errorMessages);

      // assertThat(docBookReader.errorMessages.size(), equalTo(1));
   }
}
