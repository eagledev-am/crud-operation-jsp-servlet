# Crud-Operation-jsp-servlet-css
simple crud operation using Jsp and Servlet

## screan shots of project

#### BookList image
![BookList](https://user-images.githubusercontent.com/84116267/221384292-b9dd6740-a22e-4434-9632-3e71c903fce6.png)

#### Add Item form image
![Addt](https://user-images.githubusercontent.com/84116267/221384309-a51d74cd-7637-41d2-8492-72612645d7f0.png)

#### Edit item form
![Edit](https://user-images.githubusercontent.com/84116267/221384318-d36084d3-beee-4016-94f4-ab8e450a23eb.png)

#### error page
![Error](https://user-images.githubusercontent.com/84116267/221384455-9bf6ddbf-5714-4c69-99b3-8b09d90423d7.png)

## database schema
```sql
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `title` varchar(128) NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD UNIQUE KEY `book_id_UNIQUE` (`book_id`),
  ADD UNIQUE KEY `title_UNIQUE` (`title`);


ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

```
## How to Run
You can clone the project by using this command 
```git
git clone https://github.com/egledev/Crud-Operation-jsp-servlet-css.git
```
## After cloning 
You need to install apache tomcat 8.5 
[apache](https://tomcat.apache.org/)











