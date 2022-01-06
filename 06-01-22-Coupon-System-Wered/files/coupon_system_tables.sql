create schema coupon_system;
use coupon_system;

create table `companies`(
`id` int primary key auto_increment,
`name` varchar(50),
`email` varchar(50),
`password` varchar(50)
);

create table `customers`(
`id` int primary key auto_increment,
`first_name` varchar(50),
`last_name` varchar(50),
`email` varchar(50),
`password` varchar(50)
);

create table `coupons`(
`id` int primary key auto_increment,
`company_id` int,
`category` varchar(50),
`title` varchar(50),
`description` varchar(100),
`start_date` date,
`end_date` date,
`amount` int,
`price` float,
`image` varchar(100),
foreign key(`company_id`) references `companies`(`id`)
);

create table `customers_vs_coupons`(
`customer_id` int,
`coupon_id` int,
primary key(`customer_id`, `coupon_id`),
foreign key(`customer_id`) references `customers`(`id`),
foreign key(`coupon_id`) references `coupons`(`id`)
);