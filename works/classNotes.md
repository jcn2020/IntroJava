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
