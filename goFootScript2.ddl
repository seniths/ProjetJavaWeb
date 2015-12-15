-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 9.2.0              
-- * Generator date: Oct 16 2014              
-- * Generation date: Fri Nov 27 12:05:35 2015 
-- * LUN file: C:\Users\Maxime\Google Drive\3eme\web objet\JavaWeb.lun 
-- * Schema: GoFootPostSQL/SQL1 
-- ********************************************* 


-- Database Section
-- ________________ 




-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table Category (
     idCategory integer not null,
     constraint ID_Category_ID primary key (idCategory));

create table Client (
     idClient integer generated always as identity(start with 1, increment by 1),
     login varchar(30) not null,
     password varchar(60) not null,
     firstname varchar(30) not null,
     lastname varchar(30) not null,
     mail varchar(50) not null,
     add_street varchar(30) not null,
     add_number varchar(10) not null,
     add_locality varchar(50) not null,
     add_posatlCode numeric(4) not null,
     gender boolean ,
     telNumber varchar(11) not null,
     birthdate date,
     constraint ID_Client_ID primary key (idClient),
     constraint SID_Client_ID unique (login));

create table Item (
     idItem integer generated always as identity(start with 1, increment by 1),
     price numeric(5,2) not null,
     imageSrc varchar(100) not null,
     idCategory integer not null,
     constraint ID_Item_ID primary key (idItem));

create table Language (
     idLanguage integer generated always as identity(start with 1, increment by 1),
     label varchar(20) not null,
     constraint ID_Language_ID primary key (idLanguage),
     constraint SID_Language_ID unique (label));

create table LanguageCategory (
     idLangCat integer generated always as identity(start with 1, increment by 1),
     label varchar(50) not null,
     idLanguage integer not null,
     idCategory integer not null,
     constraint ID_LanguageCategory_ID primary key (idLangCat));

create table LanguageItem (
     idLangItem integer generated always as identity(start with 1, increment by 1),
     label varchar(50) not null,
     idLanguage integer not null,
     idItem integer not null,
     constraint ID_LanguageItem_ID primary key (idLangItem));

create table ClientOrder (
     idOrder integer generated always as identity(start with 1, increment by 1),
     date date not null,
     idClient integer not null,
     constraint ID_Order_ID primary key (idOrder));

create table OrderLine (
     idOrderLine integer generated always as identity(start with 1, increment by 1),
     size char(1) not null,
     idOrder integer not null,
     idItem integer not null,
     quantity numeric(5) not null,
     price numeric(5,2) not null,
     constraint ID_OrderLine_ID primary key (idOrderLine),
     constraint SID_OrderLine_ID unique (size, idItem, idOrder));

create table Promotion (
     idPromotion integer generated always as identity(start with 1, increment by 1),
     weekNumber numeric(2) not null,
     constraint ID_Promotion_ID primary key (idPromotion));
create table PromotionCategory (
     idPromCat integer generated always as identity(start with 1, increment by 1),
     percentage numeric(4,2) not null,
     idPromotion integer not null,
     idCategory integer not null,
     constraint ID_PromotionCategory_ID primary key (idPromCat));


-- Constraints Section
-- ___________________ 

alter table Item add constraint FKCategoryItem_FK
     foreign key (idCategory)
     references Category;

alter table LanguageCategory add constraint FKLan_Lan_1_FK
     foreign key (idLanguage)
     references Language;

alter table LanguageCategory add constraint FKLan_Cat_FK
     foreign key (idCategory)
     references Category;

alter table LanguageItem add constraint FKLan_Lan_FK
     foreign key (idLanguage)
     references Language;

alter table LanguageItem add constraint FKLan_Ite_FK
     foreign key (idItem)
     references Item;

alter table ClientOrder add constraint FKOrderClient_FK
     foreign key (idClient)
     references Client;

alter table OrderLine add constraint FKOrd_Ord_FK
     foreign key (idOrder)
     references ClientOrder;

alter table OrderLine add constraint FKOrd_Ite_FK
     foreign key (idItem)
     references Item;

alter table PromotionCategory add constraint FKPro_Pro_FK
     foreign key (idPromotion)
     references Promotion;

alter table PromotionCategory add constraint FKPro_Cat_FK
     foreign key (idCategory)
     references Category;


-- Index Section
-- _____________ 

create unique index ID_Category_IND
     on Category (idCategory);

create unique index ID_Client_IND
     on Client (idClient);

create unique index SID_Client_IND
     on Client (login);

create unique index ID_Item_IND
     on Item (idItem);

create index FKCategoryItem_IND
     on Item (idCategory);

create unique index ID_Language_IND
     on Language (idLanguage);

create unique index SID_Language_IND
     on Language (label);

create unique index ID_LanguageCategory_IND
     on LanguageCategory (idLangCat);

create index FKLan_Lan_1_IND
     on LanguageCategory (idLanguage);

create index FKLan_Cat_IND
     on LanguageCategory (idCategory);

create unique index ID_LanguageItem_IND
     on LanguageItem (idLangItem);

create index FKLan_Lan_IND
     on LanguageItem (idLanguage);

create index FKLan_Ite_IND
     on LanguageItem (idItem);

create unique index ID_Order_IND
     on ClientOrder (idOrder);

create index FKOrderClient_IND
     on ClientOrder (idClient);

create unique index ID_OrderLine_IND
     on OrderLine (idOrderLine);

create unique index SID_OrderLine_IND
     on OrderLine (size, idItem, idOrder);

create index FKOrd_Ord_IND
     on OrderLine (idOrder);

create index FKOrd_Ite_IND
     on OrderLine (idItem);

create unique index ID_Promotion_IND
     on Promotion (idPromotion);

create unique index ID_PromotionCategory_IND
     on PromotionCategory (idPromCat);

create index FKPro_Pro_IND
     on PromotionCategory (idPromotion);

create index FKPro_Cat_IND
     on PromotionCategory (idCategory);

