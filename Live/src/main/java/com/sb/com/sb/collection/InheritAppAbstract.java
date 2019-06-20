package com.sb.com.sb.collection;

import java.util.*;

public class InheritAppAbstract {
	
	public static void main(String[] args) {
		//listDemo();
		setDemo();
		//mapDemo();

	}

	public Map<String, List<Account>> createMapByName(List<Account> accounts) {
		Map<String, List<Account>> result = new HashMap<>();
		for(Account a : accounts) {
			String name = a.getName();
			List<Account> l = result.get(name);
			if(l == null) {
				l = new ArrayList<>();
				result.put(name, l);
			}
			l.add(a);
		}

		List l = new ArrayList();

		return result;
	}

	public Map<Integer, Account> createMap(List<Account> accounts) {
		Map<Integer, Account> result = new HashMap<>();
		for(Account a : accounts) {
			result.put(a.getId(), a);
		}

		return result;
	}

	public static void mapDemo() {
		Map<Integer, Account> byId = new HashMap<>();


		Account ac = new CheckingAccount("Bob", 38383);
		byId.put(ac.getId(), ac);

		ac = new SavingsAccount("Bobery", 38383);
		byId.put(ac.getId(), ac);

		Set<Integer> keys = byId.keySet();
		for(Integer it : keys) {
			System.out.println(byId.get(it));
		}

		Collection<Account> values = byId.values();
		for(Account it : values) {
			System.out.println(it);
		}

		Set<Map.Entry<Integer, Account>> entries = byId.entrySet();

		for(Map.Entry<Integer, Account> it : entries) {
		    Integer key = it.getKey();
		    Account value = it.getValue();

			System.out.println(key + ": " + value);
		}
		
		byId.forEach((key, value) -> System.out.println(key + ": " + value));
	}
	
	public void someWork() {
		Set<Account> accounts = setDemo();
	}
	
	
	public static Set<Account> setDemo() {
		Set<Account> accounts = new HashSet<>();
		Account ac = new CheckingAccount("Bob", 38383);
		accounts.add(ac);
		ac = new SavingsAccount("Bobery", 38383);
		accounts.add(ac);
		accounts.add(ac);

		for(Account a : accounts) {
			System.out.println(a);
		}
		
		return accounts;

	}

	public void foo(List<Account> al) {

	}

	public List<Account> bar() {
		return null;
	}

	public static void listDemo() {
	    Account [] accounts = new Account[10];


		List<Account> lAccounts = new ArrayList<>();
		//List<Account> lAccounts = new LinkedList<>();
		Account ac = new CheckingAccount("Bob", 38383);
		lAccounts.add(ac);

		ac = new SavingsAccount("Bobery", 38383);
		lAccounts.add(ac);
		lAccounts.add(ac);

		Account a = lAccounts.get(0);

		for(int i = 0; i < lAccounts.size(); i++) {
			System.out.println(lAccounts.get(i));
		}

		for(Account ax : lAccounts) {
			//System.out.println(ax);
		}

//		Iterator<Account> iterator = lAccounts.iterator();
//		while(iterator.hasNext()) {
//			Account ax = iterator.next();
//			if(ax.getId() == 1) {
//				iterator.remove();
//			}
//			System.out.println(ax);
//		}

	}
}
