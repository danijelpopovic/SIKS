/***********************************************************************
 * Module:  Koraci.java
 * Author:  Pop
 * Purpose: Defines the Class Koraci
 ***********************************************************************/

package modevovanjeZivotnogCiklusaSoftvera;

import java.util.*;

/** @pdOid cbe5cc23-8d27-4558-ab63-d7848d58aefd */
public class Koraci {
   /** @pdOid c42ab156-0230-46cd-8aba-51970a2df3ec */
   public int identifikator;
   /** @pdOid 3da6ba83-17fa-44d9-abd8-6c658bdabb83 */
   public java.lang.String naziv;
   
   /** @pdRoleInfo migr=no name=StrukturaModela assc=korakUModelu coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<StrukturaModela> strukturaModela;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<StrukturaModela> getStrukturaModela() {
      if (strukturaModela == null)
         strukturaModela = new java.util.HashSet<StrukturaModela>();
      return strukturaModela;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStrukturaModela() {
      if (strukturaModela == null)
         strukturaModela = new java.util.HashSet<StrukturaModela>();
      return strukturaModela.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStrukturaModela */
   public void setStrukturaModela(java.util.Collection<StrukturaModela> newStrukturaModela) {
      removeAllStrukturaModela();
      for (java.util.Iterator iter = newStrukturaModela.iterator(); iter.hasNext();)
         addStrukturaModela((StrukturaModela)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStrukturaModela */
   public void addStrukturaModela(StrukturaModela newStrukturaModela) {
      if (newStrukturaModela == null)
         return;
      if (this.strukturaModela == null)
         this.strukturaModela = new java.util.HashSet<StrukturaModela>();
      if (!this.strukturaModela.contains(newStrukturaModela))
         this.strukturaModela.add(newStrukturaModela);
   }
   
   /** @pdGenerated default remove
     * @param oldStrukturaModela */
   public void removeStrukturaModela(StrukturaModela oldStrukturaModela) {
      if (oldStrukturaModela == null)
         return;
      if (this.strukturaModela != null)
         if (this.strukturaModela.contains(oldStrukturaModela))
            this.strukturaModela.remove(oldStrukturaModela);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStrukturaModela() {
      if (strukturaModela != null)
         strukturaModela.clear();
   }

}