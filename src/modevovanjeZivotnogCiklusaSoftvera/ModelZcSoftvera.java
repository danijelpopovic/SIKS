/***********************************************************************
 * Module:  ModelZcSoftvera.java
 * Author:  Pop
 * Purpose: Defines the Class ModelZcSoftvera
 ***********************************************************************/

package modevovanjeZivotnogCiklusaSoftvera;

import java.util.*;

/** @pdOid c4d4a276-6bbd-4e82-8330-d298a00fc248 */
public class ModelZcSoftvera {
   /** @pdOid 2c2fa650-1d69-49bf-876f-d1545bd6f036 */
   public int oznaka;
   /** @pdOid cce71fff-36ef-4a23-947c-8bab9adeeb7e */
   public java.lang.String naziv;
   /** @pdOid 9cb06a3f-866a-4007-aea5-8dd95a717ac8 */
   public java.lang.String skraceniNaziv;
   /** @pdOid 45f060de-b59d-4cfc-af49-bd6585bf6056 */
   public java.lang.String opis;
   
   /** @pdRoleInfo migr=no name=StrukturaModela assc=struktura coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
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