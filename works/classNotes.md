###  Lambda

- sort account
  - what to compare. sorting criteria (by id, balance, status)
    - implement **strategy** as separate -- severals of them - hiding in interface.
    - plug into algo
- List<Accounts> accounts = new ArrayList<>() ; 

Interface -> must implement to get concrete

Interface  implements Interface?  

` public interface Account extends Comparable<Account>  '
```

```
- sort -- public  satic <T> void sort ( List<T> list, Comparator<T> ) 
```
  class nameComparator implements Comparator<Account> {
     @Override
     public int compare(Account account1, Account account2) {
        return account1.getName.getName().compareTo)account2.getName()) ; 
     }
  }
```
Quests - 
- What is java strategy. 
  
ToDo
- class define inside a class.
```
public class MainClass { 
   public static class SubClass { }
}
```
  
