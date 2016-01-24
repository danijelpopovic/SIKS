/***********************************************************************
 * Module:  StrukturaModela.java
 * Author:  Pop
 * Purpose: Defines the Class StrukturaModela
 ***********************************************************************/

package modevovanjeZivotnogCiklusaSoftvera;

import java.util.*;

/** @pdOid 17372300-5d5e-4495-965c-3ad88757907d */
public class StrukturaModela {
   /** @pdOid 362203f1-4a7d-4eed-bea7-f5bc74da0954 */
   public double nivo;
   /** @pdOid 2b63550e-818c-4574-bc4b-1cab537db5ee */
   public double polozajUNivou;
   
   /** @pdRoleInfo migr=no name=StrukturaModela assc=hiperlinkovi coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<StrukturaModela> strukturaModelaB;
   /** @pdRoleInfo migr=no name=StrukturaModela assc=hiperlinkovi coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   public java.util.Collection<StrukturaModela> strukturaModelaA;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<StrukturaModela> getStrukturaModelaB() {
      if (strukturaModelaB == null)
         strukturaModelaB = new java.util.HashSet<StrukturaModela>();
      return strukturaModelaB;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStrukturaModelaB() {
      if (strukturaModelaB == null)
         strukturaModelaB = new java.util.HashSet<StrukturaModela>();
      return strukturaModelaB.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStrukturaModelaB */
   public void setStrukturaModelaB(java.util.Collection<StrukturaModela> newStrukturaModelaB) {
      removeAllStrukturaModelaB();
      for (java.util.Iterator iter = newStrukturaModelaB.iterator(); iter.hasNext();)
         addStrukturaModelaB((StrukturaModela)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStrukturaModela */
   public void addStrukturaModelaB(StrukturaModela newStrukturaModela) {
      if (newStrukturaModela == null)
         return;
      if (this.strukturaModelaB == null)
         this.strukturaModelaB = new java.util.HashSet<StrukturaModela>();
      if (!this.strukturaModelaB.contains(newStrukturaModela))
      {
         this.strukturaModelaB.add(newStrukturaModela);
         newStrukturaModela.addStrukturaModelaA(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStrukturaModela */
   public void removeStrukturaModelaB(StrukturaModela oldStrukturaModela) {
      if (oldStrukturaModela == null)
         return;
      if (this.strukturaModelaB != null)
         if (this.strukturaModelaB.contains(oldStrukturaModela))
         {
            this.strukturaModelaB.remove(oldStrukturaModela);
            oldStrukturaModela.removeStrukturaModelaA(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStrukturaModelaB() {
      if (strukturaModelaB != null)
      {
         StrukturaModela oldStrukturaModela;
         for (java.util.Iterator iter = getIteratorStrukturaModelaB(); iter.hasNext();)
         {
            oldStrukturaModela = (StrukturaModela)iter.next();
            iter.remove();
            oldStrukturaModela.removeStrukturaModelaA(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<StrukturaModela> getStrukturaModelaA() {
      if (strukturaModelaA == null)
         strukturaModelaA = new java.util.HashSet<StrukturaModela>();
      return strukturaModelaA;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStrukturaModelaA() {
      if (strukturaModelaA == null)
         strukturaModelaA = new java.util.HashSet<StrukturaModela>();
      return strukturaModelaA.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStrukturaModelaA */
   public void setStrukturaModelaA(java.util.Collection<StrukturaModela> newStrukturaModelaA) {
      removeAllStrukturaModelaA();
      for (java.util.Iterator iter = newStrukturaModelaA.iterator(); iter.hasNext();)
         addStrukturaModelaA((StrukturaModela)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStrukturaModela */
   public void addStrukturaModelaA(StrukturaModela newStrukturaModela) {
      if (newStrukturaModela == null)
         return;
      if (this.strukturaModelaA == null)
         this.strukturaModelaA = new java.util.HashSet<StrukturaModela>();
      if (!this.strukturaModelaA.contains(newStrukturaModela))
      {
         this.strukturaModelaA.add(newStrukturaModela);
         newStrukturaModela.addStrukturaModelaB(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStrukturaModela */
   public void removeStrukturaModelaA(StrukturaModela oldStrukturaModela) {
      if (oldStrukturaModela == null)
         return;
      if (this.strukturaModelaA != null)
         if (this.strukturaModelaA.contains(oldStrukturaModela))
         {
            this.strukturaModelaA.remove(oldStrukturaModela);
            oldStrukturaModela.removeStrukturaModelaB(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStrukturaModelaA() {
      if (strukturaModelaA != null)
      {
         StrukturaModela oldStrukturaModela;
         for (java.util.Iterator iter = getIteratorStrukturaModelaA(); iter.hasNext();)
         {
            oldStrukturaModela = (StrukturaModela)iter.next();
            iter.remove();
            oldStrukturaModela.removeStrukturaModelaB(this);
         }
      }
   }

}