USE [master]
GO

CREATE DATABASE [CakeManagement] 
GO

USE [CakeManagement]
GO

CREATE TABLE [dbo].[tblProducts](
	[productID] [char](5) NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[description] [varchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblProducts] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'T001 ', N'BirthayCake', N'Banh kem sinh nhat', 100, 1)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'T002 ', N'HappyCake', N'Banh kem hanh phuc', 200, 1)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'T003 ', N'LuckyCake', N'Banh kem may man', 500, 0)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'T004 ', N'StrawberryCake', N'Banh kem dau', 300, 1)
INSERT [dbo].[tblProducts] ([productID], [productName], [description], [price], [status]) VALUES (N'T004 ', N'FruitCake', N'Banh kem trai cay', 300, 1)
