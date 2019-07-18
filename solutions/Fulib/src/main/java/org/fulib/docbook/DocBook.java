package org.fulib.docbook;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class DocBook  
{

   public static final java.util.TreeSet<Section> EMPTY_sections = new java.util.TreeSet<Section>()
   { @Override public boolean add(Section value){ throw new UnsupportedOperationException("No direct add! Use xy.withSections(obj)"); }};


   public static final String PROPERTY_sections = "sections";

   private java.util.TreeSet<Section> sections = null;

   public java.util.TreeSet<Section> getSections()
   {
      if (this.sections == null)
      {
         return EMPTY_sections;
      }

      return this.sections;
   }

   public DocBook withSections(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections == null)
            {
               this.sections = new java.util.TreeSet<Section>();
            }
            if ( ! this.sections.contains(item))
            {
               this.sections.add((Section)item);
               ((Section)item).setBook(this);
               firePropertyChange("sections", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public DocBook withoutSections(Object... value)
   {
      if (this.sections == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections.contains(item))
            {
               this.sections.remove((Section)item);
               ((Section)item).setBook(null);
               firePropertyChange("sections", item, null);
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



   public void removeYou()
   {
      this.withoutSections(this.getSections().clone());


   }










}