package test

import test.User.lastName
import test.User.firstName
import java.util.ArrayList

//import java.util.ArrayList;
//import java.util.List;
//
//public class test.Repository {
//
//    private static test.Repository INSTANCE = null;
//
//    private List<test.User> users = null;
//
//    public static test.Repository getInstance() {
//        if (INSTANCE == null) {
//            synchronized (test.Repository.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new test.Repository();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    // keeping the constructor private to enforce the usage of getInstance
//    private test.Repository() {
//
//        test.User user1 = new test.User("Jane", "");
//        test.User user2 = new test.User("John", null);
//        test.User user3 = new test.User("Anne", "Doe");
//
//        users = new ArrayList();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//    }
//
//    public List<test.User> getUsers() {
//        return users;
//    }
//
//    public List<String> getFormattedUserNames() {
//        List<String> userNames = new ArrayList<>(users.size());
//        for (test.User user : users) {
//            String name;
//
//            if (user.getLastName() != null) {
//                if (user.getFirstName() != null) {
//                    name = user.getFirstName() + " " + user.getLastName();
//                } else {
//                    name = user.getLastName();
//                }
//            } else if (user.getFirstName() != null) {
//                name = user.getFirstName();
//            } else {
//                name = "Unknown";
//            }
//            userNames.add(name);
//        }
//        return userNames;
//    }
//}

object Repository {
    private val _users = mutableListOf<User>()
    val users: List<User>
        get() = _users

//    val formattedUserNames: List<String>
//        get() {
//            val userNames: MutableList<String> = ArrayList(users.size)
//            for ((firstName, lastName) in users) {
//                val name: String
//                name = if (lastName != null) {
//                    if (firstName != null) {
//                        "$firstName $lastName"
//                    } else {
//                        lastName
//                    }
//                } else {
//                    firstName ?: "Unknown"
//                }
//                userNames.add(name)
//            }
//            return userNames
//        }

//    val formattedUserNames: List<String>
//        get() {
//            return users.map { user ->
//                if (user.lastName != null) {
//                    if (user.firstName != null) {
//                        "${user.firstName} ${user.lastName}"
//                    } else {
//                        user.lastName ?: "Unknown"
//                    }
//                }  else {
//                    user.firstName ?: "Unknown"
//                }
//            }
//        }

    val formattedUserNames: List<String>
        get() {
            return _users.map { user -> user.userFormattedName }
        }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")

        _users.apply {
            add(user1)
            add(user2)
            add(user3)
        }
//        _users.add(user1)
//        _users.add(user2)
//        _users.add(user3)
    }
}

// extension function
fun User.getFormattedName(): String {
    return if (lastName != null) {
        if (firstName != null) {
            "$firstName $lastName"
        } else {
            lastName ?: "Unknown"
        }
    } else {
        firstName ?: "Unknown"
    }
}

// extension property
val User.userFormattedName: String
    get() {
        return if (lastName != null) {
            if (firstName != null) {
                "$firstName $lastName"
            } else {
                lastName ?: "Unknown"
            }
        } else {
            firstName ?: "Unknown"
        }
    }
// usage:
//val user = User(...)
//val name = user.getFormattedName()
//val formattedName = user.userFormattedName
