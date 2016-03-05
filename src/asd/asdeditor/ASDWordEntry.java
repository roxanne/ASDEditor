/*

Copyright 2001 James A. Mason

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy
of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.

 */





/* 
 
Copyright 2010 James A. Mason 
 
Licensed under the Apache License, Version 2.0 (the "License"); you may not 
use this file except in compliance with the License. You may obtain a copy 
of the License at 
 
http://www.apache.org/licenses/LICENSE-2.0 
 
Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
License for the specific language governing permissions and limitations 
under the License. 
 
 */ 
 
package asd.asdeditor; 
import java.util.*; 
 
/** 
   Instances are entries for an ASDGrammar, consisting of 
   a word and an ArrayList of instances for that word. 
   Visibility is restricted to the asd package. 
   @author James A. Mason 
   @version 1.02 2001 Oct 10; 2010 Aug 
 */ 
class ASDWordEntry implements Comparable 
{ 
   ASDWordEntry(String wd, ArrayList<ASDGrammarNode> inst) 
   { 
      word = wd; 
      instances = inst; 
   } 
 
   public int compareTo(Object other) 
   {  ASDWordEntry otherEntry = (ASDWordEntry)other; 
      String myWord = word.toLowerCase(); 
      String otherWord = otherEntry.getWord().toLowerCase(); 
      return myWord.compareTo(otherWord); 
   } 
 
   String getWord() { return word; } 
 
   ArrayList<ASDGrammarNode> getInstances() { return instances; } 
 
   private String word; 
   private ArrayList<ASDGrammarNode> instances; 
} // end class ASDWordEntry 





