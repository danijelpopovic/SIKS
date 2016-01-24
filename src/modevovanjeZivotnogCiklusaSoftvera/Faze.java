/***********************************************************************
 * Module:  Faze.java
 * Author:  Pop
 * Purpose: Defines the Class Faze
 ***********************************************************************/

package modevovanjeZivotnogCiklusaSoftvera;

import java.util.*;

/** @pdOid e943bf22-4475-4d2b-957d-de11234458e5 */
public class Faze {
   /** @pdOid 6754383f-4eaf-4690-a3f6-c66f2ad7cfb4 */
   public short oznaka;
   /** @pdOid c80ee556-33a5-4a7c-9de2-fcb1303b52e5 */
   public java.lang.String nazivFaze;
   
   /** @pdRoleInfo migr=no name=Koraci assc=pripadajuKoraci coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Koraci> koraci;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Koraci> getKoraci() {
      if (koraci == null)
         koraci = new java.util.HashSet<Koraci>();
      return koraci;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKoraci() {
      if (koraci == null)
         koraci = new java.util.HashSet<Koraci>();
      return koraci.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKoraci */
   public void setKoraci(java.util.Collection<Koraci> newKoraci) {
      removeAllKoraci();
      for (java.util.Iterator iter = newKoraci.iterator(); iter.hasNext();)
         addKoraci((Koraci)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKoraci */
   public void addKoraci(Koraci newKoraci) {
      if (newKoraci == null)
         return;
      if (this.koraci == null)
         this.koraci = new java.util.HashSet<Koraci>();
      if (!this.koraci.contains(newKoraci))
         this.koraci.add(newKoraci);
   }
   
   /** @pdGenerated default remove
     * @param oldKoraci */
   public void removeKoraci(Koraci oldKoraci) {
      if (oldKoraci == null)
         return;
      if (this.koraci != null)
         if (this.koraci.contains(oldKoraci))
            this.koraci.remove(oldKoraci);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKoraci() {
      if (koraci != null)
         koraci.clear();
   }

}