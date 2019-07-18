package org.fulib.modelgen;

import org.fulib.Fulib;
import org.fulib.builder.AssociationBuilder;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;

public class FulibModelGenerator
{
   public static void main(String[] args)
   {
      ClassModelBuilder mb = Fulib.classModelBuilder("org.fulib.docbook");
      ClassBuilder docBook = mb.buildClass("DocBook");
      ClassBuilder section = mb.buildClass("Section").buildAttribute("title", mb.STRING);
      ClassBuilder paragraph = mb.buildClass("Paragraph").buildAttribute("content", mb.STRING);

      AssociationBuilder sectionAssoc = docBook.buildAssociation(section, "sections", mb.MANY, "book", mb.ONE);
      sectionAssoc.setSourceRoleCollection(java.util.TreeSet.class);

      section.buildAssociation(paragraph, "paras", mb.MANY, "section", mb.ONE)
         .setSourceRoleCollection(java.util.TreeSet.class);

      Fulib.generator().generate(mb.getClassModel());
   }
}
