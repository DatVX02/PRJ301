USE [master]
GO

CREATE DATABASE [Library] 
GO

USE [Library]
GO

CREATE TABLE [dbo].[tblUsers](
	[id ] [nvarchar](50) NOT NULL,
	[fullname ] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[username ] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblUsers] ([fullname], [password], [roleID]) VALUES (N'admin', N'Toi la admin', N'1', N'AD')
INSERT [dbo].[tblUsers] ([fullname], [password], [roleID]) VALUES (N'thulvm', N'Minh Thu', N'1', N'AD')
INSERT [dbo].[tblUsers] ([fullname], [password], [roleID]) VALUES (N'SE170969', N'Nguyen Gia Tin', N'123', N'US')
INSERT [dbo].[tblUsers] ([fullname], [password], [roleID]) VALUES (N'SE170443', N'LE MINH KHOA', N'1', N'US')

CREATE TABLE [dbo].[tblAirplane](
	[id] [char](5) NOT NULL,
	[flightNumber] [nvarchar](50) NOT NULL,
	[destination] [nvarchar](500) NOT NULL,
	
	[departureTime] [nvarchar](50) NOT NULL,
	[delayed] [bit] NOT NULL,
 CONSTRAINT [PK_tblFashion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblAirplane] ([id], [flightNumber], [destination], [departureTime], [delayed]) VALUES (N'C-001', N'Skin care', N'Chăm sóc da', 200,4)
INSERT [dbo].[tblAirplane] ([id], [flightNumber], [destination], [departureTime], [delayed]) VALUES (N'C-002', N'Hair', N'Chăm sóc tóc', 300,5)
