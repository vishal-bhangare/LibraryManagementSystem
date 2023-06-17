
# Library Management System


I have created this project to manage libary transactions and show some statistics using collected data, this will help to manage library in easy way.

This is 1st release of this project, it will be improved overtime.

Your are free to use this project.

## Installation

Requirement : Java 1.8 or later

If you have java installed on your system just download `.jar` file and run directly.

otherwise download `.zip` file which is included with Java runtime. Extract zip file and run `LibraryManagementSystem.bat` file.
## Source code

If you want to do update in project you can download project folder from repo.

## Database Structure

#### Admin table
|Column|Data type|
|------|--------|
|id	|tinyint|
|username|varchar(40)|
|password|varchar(20)|

#### Librarians table
|Column|Data type|
|------|--------|
|id	      	|tinyint Auto Increment	|
|firstname	|varchar(20)	|
|lastname	|varchar(20)	|
|contact_no	|bigint	|
|email_id|	varchar(50)	|
|dob	|date|

#### Students table
|Column|Data type|
|------|--------|
|sr_no	|mediumint Auto Increment	|
|firstname	|varchar(20)	|
|lastname	|varchar(20)	|
|student_id	|int	|
|contact_no|	bigint	|
|email_id|	varchar(50)	|
|dob|	date|


#### Books table
|Column|Data type|
|------|--------|
|sr_no		|mediumint Auto Increment	|
|Book_id	|	mediumint	|
|Book_name	|varchar(100)	|
|Author		|varchar(50)	|
|Publication|	varchar(50)	|
|isbn_no	|	varchar(20)	|
|Category	|varchar(20)	|
|Quantity	|tinyint|

#### Records table
|Column|Data type|
|------|--------|
|sr_no	|int Auto Increment	|
|book_id	|smallint	|
|book_name	|varchar(100)	|
|student_id|	smallint	|
|student_name	|varchar(50)	|
|issue_date	|date	|
|return_date|	date NULL|	
|penalty	|smallint [0]|	
|reissue	|tinyint [0]	|
|feedback	|varchar(25) []	|
|condition|	varchar(25) []|
