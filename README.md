Java library that helps you to create SQL queries using Java objects instead of using raw text.
# Set up
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.JaimeTruman</groupId>
    <artifactId>MySQL-Query-Builder</artifactId>
    <version>1.0.1</version>
</dependency>
```



### SELECT 

```sql
SELECT * FROM players WHERE money >= 1000 ORDER BY money ASC LIMIT 3
```
```java
String query = Select.from("players")
          .where("money").biggerOrEqual(1000)
          .orderBy("money", Order.ASC)
          .limit(3)
          .build();
```

### INSERT

```sql
INSERT INTO players (name, money) VALUES ('jaimetruman', 100)
```
```java
String query = Insert.table("players")
          .fields("name", "money")
          .values("jaimetruman", 100)
          .build();
```

### UPDATE

```sql
UPDATE players SET money = 100, test = 1 WHERE name = 'jaimetruman'
```
```java
String query = Update.table("players")
          .set("money", 100)
          .andSet("test", 1)
          .where("name").equal("jaimetruman")
          .build();
```

### DELETE

```sql
DELETE FROM players WHERE name = 'jaimetruman' OR money >= 100
```
```java
String query = Delete.from("players")
          .where("name")
          .equal("jaimetruman")
          .or("money").biggerOrEqual(100)
          .build();
```

### CustomSerializer

```sql
INSERT INTO users_json (json) VALUES ("{'name': 'Jaime', 'creationTime': 10}")
```
```java
MySQLQueryBuilder.addCustomSerializer(User.class, new UserSerializer());

Insert.table("users_json")         
        .fields("json")
        .values(new User("Jaime", 10));

public class UserSerializer implements DatabaseTypeSerializer<User> {
    @Override
    public String serialize(User user) {
        return String.format("\"{'name': '%s', 'creationTime': %s}\"", user.username, user.creationTime);
    } 
}

@AllArgsConstructor
public class User {
    String username;
    long creationTime;
}

```
