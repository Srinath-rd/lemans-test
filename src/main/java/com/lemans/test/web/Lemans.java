package com.lemans.test.web;

import java.util.*;
import java.util.stream.Collectors;

public class Lemans {

  /** @param args Main method */
  public static void main(String[] args) {

    // 1st question
    Integer[] a = new Integer[65];
    Arrays.fill(a, 65);
    System.out.println(Arrays.toString(a));
    createList(Arrays.asList(a));

    // 2nd question
    Lemans lemans = new Lemans();
    lemans.groupUserByAge();

    createMapOfChars();
  }

  /**
   * @param numberList
   *     <p>Section 1: 1. Create a new List, and fill it with 26 65's (the resulting list would have
   *     a size of 26, and all values equal 65) I. Morph the contents of the List such that the
   *     value at each index equals the value + the index.
   */
  public static List<Integer> createList(List<Integer> numberList) {
    //    Arrays.
    return numberList.stream()
        .map(integer -> integer + numberList.indexOf(integer))
        .collect(Collectors.toList());
  }

  /**
   * 2. Create a new List and fill it with 4 User's(User is a POJO with name and age) ([{Paul, 10},
   * {David, 10}, {Mike, 15}, {Mark, 20}]) I. Group the users by age II. List out all the Users that
   * have age above 10
   */
  public void groupUserByAge() {

    List<User> users = createUsers();

    // group users by age
    List<User> usersByAge =
        users.stream().filter(user -> user.age > 10).collect(Collectors.toList());

    Map<Integer, List<User>> groupedUsersByAge = usersByAge.stream().collect(Collectors.groupingBy(User::getAge));
    groupedUsersByAge.forEach((k, v) -> System.out.println("Key: " + k + "value" + v));
    usersByAge.forEach(System.out::println);

  }

  /**
   * 3. Create a Map with <String, Integer>, populate the key with Alphabet and the value with the
   * corresponding Alphabet Number (A:1, B:2, C:3, etc.) I. Iterate over the Map and multiply the
   * value with 2.
   */
  public static void createMapOfChars(){
    Map<Character, Integer> mapOfChars = new HashMap<>();
    int count = 1;
    for(char i = 'a'; i <= 'z'; i++){
      mapOfChars.put(i, count++);
    }
    mapOfChars.forEach((k, v) -> System.out.println("key: " + k + " Value:" +  v));

    Map<Character, Integer> modifiedMapOfChars = mapOfChars.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, characterIntegerEntry -> 2 * characterIntegerEntry.getValue()));

    modifiedMapOfChars.forEach((k, v) -> System.out.println("key: " + k + " Value:" +  v));

  }


  private List<User> createUsers() {
    List<User> users = new ArrayList<>();
    User user1 = new User();
    user1.setName("Paul");
    user1.setAge(10);
    users.add(user1);

    User user2 = new User();
    user2.setName("David");
    user2.setAge(10);
    users.add(user2);

    User user3 = new User();
    user3.setName("Mike");
    user3.setAge(15);
    users.add(user3);

    User user4 = new User();
    user4.setName("Mark");
    user4.setAge(20);
    users.add(user4);

    User user5 = new User();
    user5.setName("John");
    user5.setAge(15);
    users.add(user5);

    return users;
  }

  class User {
    private String name;
    private Integer age;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
  }
}
