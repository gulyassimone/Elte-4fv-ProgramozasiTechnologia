/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Simone Gulyas
 * Created: 2021. máj. 22.
 */
create DATABASE snake;
USE snake;


create table high_score(
    id Integer(5) NOT NULL AUTO_INCREMENT,
    score Integer(5) NOT NULL,
    name varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

select  * from high_score;