# MySQL query builder


This library provides a way to create mysql queries without with objects, without wrinting any "string".

### SELECT 

This example will generate. SELECT * FROM players WHERE money >= 1000 ORDER BY money ASC LIMIT 3

```java
String query = Select.from("players")
          .where("money").biggerOrEqual(1000)
          .orderBy("money", Order.ASC)
          .limit(3)
          .build();
```

This example will generate. INSERT INTO players (name, money) VALUES ('jaimetruman', 100)

```java
String query = Insert.table("players")
          .fields("name", "money")
          .values("jaimetruman", 100)
          .build();
```

This example will generate. UPDATE players SET money = 100, test = 1 WHERE name = 'jaimetruman'

```java
String query = Update.table("players")
          .set("money", 100)
          .andSet("test", 1)
          .where("name").equal("jaimetruman")
          .build();
```
This example will generate. DELETE FROM players WHERE name = 'jaimetruman' OR money >= 100

```java
String query = Delete.from("players")
          .where("name")
          .equal("jaimetruman")
          .or("money").biggerOrEqual(100)
          .build();
```
