
CREATE SEQUENCE [Sequence_postNum] AS bigint
START WITH 1000
INCREMENT BY 1
go

CREATE TABLE [bookMark]
( 
	[customerId]         INT(6)  NOT NULL ,
	[postNum]            INT(6)  NOT NULL 
)
go

ALTER TABLE [bookMark]
	ADD CONSTRAINT [XPKbookMark] PRIMARY KEY  CLUSTERED ([customerId] ASC,[postNum] ASC)
go

CREATE TABLE [calendar]
( 
	[day]                char(8)  NOT NULL ,
	[content]            VARCHAR2(MAX)  NULL ,
	[point]              integer  NULL ,
	[color]              VARCHAR2(15)  NULL ,
	[customerId]         INT(6)  NOT NULL 
)
go

ALTER TABLE [calendar]
	ADD CONSTRAINT [XPKcalendar] PRIMARY KEY  CLUSTERED ([day] ASC,[customerId] ASC)
go

CREATE TABLE [item]
( 
	[activity]           numeric(38)  NOT NULL ,
	[itemReward]         numeric(38)  NOT NULL ,
	[itemNo]             numeric(38)  NOT NULL ,
	[day]                char(8)  NULL ,
	[customerId]         INT(6)  NULL 
)
go

ALTER TABLE [item]
	ADD CONSTRAINT [XPKitem] PRIMARY KEY  CLUSTERED ([itemNo] ASC)
go

CREATE TABLE [post]
( 
	[postNum]            char(18)  NOT NULL ,
	[title]              VARCHAR2(50)  NOT NULL ,
	[category]           VARCHAR2(20)  NOT NULL ,
	[content]            VARCHAR2(MAX)  NOT NULL ,
	[visitCnt]           integer  NULL ,
	[customerId]         INT(6)  NULL 
)
go

ALTER TABLE [post]
	ADD CONSTRAINT [XPKpost] PRIMARY KEY  CLUSTERED ([postNum] ASC)
go

CREATE TABLE [USERINFO]
( 
	[id]                 INT(6)  NOT NULL ,
	[password]           VARCHAR2(20)  NOT NULL ,
	[name]               VARCHAR2(max)  NOT NULL ,
	[phoneNumber]        VARCHAR2(13)  NOT NULL ,
	[email]              VARCHAR2(50)  NOT NULL ,
	[address]            VARCHAR2(50)  NULL ,
	[birth]              datetime  NULL ,
	[nickName]           VARCHAR2(20)  NOT NULL ,
	[point]              integer  NULL ,
	[meeting]            VARCHAR2(50)  NULL ,
	[regDate]            datetime  NULL 
)
go

ALTER TABLE [USERINFO]
	ADD CONSTRAINT [XPKcustomer] PRIMARY KEY  CLUSTERED ([id] ASC)
go

CREATE VIEW [user_meeting_Info]([id],[name],[point],[meeting],[phoneNumber],[email],[birth])
AS
SELECT [USERINFO].[id],[USERINFO].[name],[USERINFO].[point],[USERINFO].[meeting],[USERINFO].[phoneNumber],[USERINFO].[email],[USERINFO].[birth]
	FROM [USERINFO]
go


ALTER TABLE [bookMark]
	ADD CONSTRAINT [R_53] FOREIGN KEY ([customerId]) REFERENCES [USERINFO]([id])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go

ALTER TABLE [bookMark]
	ADD CONSTRAINT [R_54] FOREIGN KEY ([postNum]) REFERENCES [post]([postNum])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go


ALTER TABLE [calendar]
	ADD CONSTRAINT [R_51] FOREIGN KEY ([customerId]) REFERENCES [USERINFO]([id])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go


ALTER TABLE [item]
	ADD CONSTRAINT [R_71] FOREIGN KEY ([day],[customerId]) REFERENCES [calendar]([day],[customerId])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go


ALTER TABLE [post]
	ADD CONSTRAINT [R_69] FOREIGN KEY ([customerId]) REFERENCES [USERINFO]([id])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go
