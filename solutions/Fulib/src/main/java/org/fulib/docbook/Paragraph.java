package org.fulib.docbook;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Paragraph  implements Comparable
{

   public static final String PROPERTY_content = "content";

   private String content;

   public String getContent()
   {
      return content;
   }

   public Paragraph setContent(String value)
   {
      if (value == null ? this.content != null : ! value.equals(this.content))
      {
         String oldValue = this.content;
         this.content = value;
         firePropertyChange("content", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_section = "section";

   private Section section = null;

   public Section getSection()
   {
      return this.section;
   }

   public Paragraph setSection(Section value)
   {
      if (this.section != value)
      {
         Section oldValue = this.section;
         if (this.section != null)
         {
            this.section = null;
            oldValue.withoutParas(this);
         }
         this.section = value;
         if (value != null)
         {
            value.withParas(this);
         }
         firePropertyChange("section", oldValue, value);
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

      result.append(" ").append(this.getContent());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setSection(null);

   }


   @Override
   public int compareTo(Object o)
   {
      return this.toString().compareTo(o.toString());
   }
}