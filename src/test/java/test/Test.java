package test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    String name, role;

    Test(String a, String b) {
        name = a;
        role = b;
    }

    String getRole() { return role; }
    String getName() { return name; }

    public String dataDP() {
        return "User Name : " + name + ", Role :" + role;
    }



    public static void main(String[] agrs) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("12", String::length);

        Integer value2 = nameMap.computeIfAbsent("12345", s -> s.length());

        System.out.println(value);
        System.out.println(value2);

        System.out.println("============================================================================");

//      Two-Arity Function Specializations  ============================================================================


        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);

        System.out.println(salaries);

        System.out.println("============================================================================");

//       ============================================================================

        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        names.forEach(name -> System.out.println("Hello, " + name));

        System.out.println("============================================================================");

        //      Consumers  ============================================================================

        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);

        ages.forEach((name, age) ->
                System.out.println(name + " is " + age + " years old"));



        System.out.println("============================================================================");


        //    Predicates    ============================================================================

        List<String> name2 = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
        List<String> name3 = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

        List<String> namesWithA = name2.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());

        name2.replaceAll(n -> n.toUpperCase());
        name3.replaceAll(String::toLowerCase);
        System.out.println(name2 + "\n" + name3);

        System.out.println(namesWithA);

        System.out.println("============================================================================");

        List<Test> users = new ArrayList<Test>();
        users.add(new Test("John", "admin"));
        users.add(new Test("Peter", "member"));

        // This line uses Predicates to filter
        // o tuthe list of users with the role "admin".
        // List admins = process(users, (User u) ->
        // u.getRole().equals("admin"));

        // Replacing it with the following line
        // using Stream API and lambda functions
        // produces the same output

        // the input to the filter() is a lambda
        // expression that returns a predicate: a
        // boolean value for each user encountered
        // (true if admin, false otherwise)
        List admins = users.stream()
                .filter((u) -> u.getRole().equals("admin"))
                .collect(Collectors.toList());

        System.out.println(admins);


    }


}
