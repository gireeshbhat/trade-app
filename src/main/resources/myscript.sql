CREATE TABLE Order (
    OrderId INT NOT NULL AUTO_INCREMENT,
    Side VARCHAR(10) NOT NULL,
    Security VARCHAR(10) NOT NULL,
    FundName VARCHAR(10) NOT NULL,
	Quantity INT NOT NULL,
	Price INT NOT NULL,
    PRIMARY KEY (OrderId)
);

insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','AAPL','MAG',10000,100);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','GOOG','CONT',1000,700);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','VAN','FP1,',1000,10);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','AAPL','MAG',2000,100);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Sell','T','F2',1000,30);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','VZ','CANA',1000,50);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','GOOG','CANA',1000,700);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Sell','VAN','FBSC',1000,10);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Buy','AAPL','FBIO',2000,100);
insert into Order(Side,Security,FundName,Quantity,Price) VALUES('Sell','T','F2',1000,30);