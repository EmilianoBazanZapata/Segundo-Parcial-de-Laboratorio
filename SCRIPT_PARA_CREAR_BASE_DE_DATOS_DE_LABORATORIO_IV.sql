USE [master]
GO
/****** Object:  Database [Club]    Script Date: 28/10/2020 19:04:49 ******/
CREATE DATABASE [Club]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Club', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Club.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Club_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Club_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Club] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Club].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Club] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Club] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Club] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Club] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Club] SET ARITHABORT OFF 
GO
ALTER DATABASE [Club] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Club] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Club] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Club] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Club] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Club] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Club] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Club] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Club] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Club] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Club] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Club] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Club] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Club] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Club] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Club] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Club] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Club] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Club] SET  MULTI_USER 
GO
ALTER DATABASE [Club] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Club] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Club] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Club] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Club] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Club]
GO
/****** Object:  Table [dbo].[Actividad_x_Socio]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividad_x_Socio](
	[Id_Actividad] [int] NOT NULL,
	[Id_Socio] [int] NOT NULL,
	[Activo] [bit] NOT NULL,
 CONSTRAINT [PK_Actividad_x_Socio] PRIMARY KEY CLUSTERED 
(
	[Id_Actividad] ASC,
	[Id_Socio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Actividades]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividades](
	[Id_Actividad] [int] IDENTITY(1,1) NOT NULL,
	[Actividad] [nvarchar](50) NOT NULL,
	[Precio] [float] NOT NULL,
	[Activo] [bit] NULL,
 CONSTRAINT [PK_Actividades] PRIMARY KEY CLUSTERED 
(
	[Id_Actividad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Administrador]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administrador](
	[Id_Administrador] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[Contraseña] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Administrador] PRIMARY KEY CLUSTERED 
(
	[Id_Administrador] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Detalle_Factura]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Detalle_Factura](
	[Id_Factura] [int] NOT NULL,
	[Id_Actividades] [int] NOT NULL,
	[Monto_Unitario] [float] NOT NULL,
 CONSTRAINT [PK_Detalle_Factura] PRIMARY KEY CLUSTERED 
(
	[Id_Factura] ASC,
	[Id_Actividades] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Factura]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Factura](
	[Num_Factura] [int] IDENTITY(0,1) NOT NULL,
	[Id_Socio] [int] NOT NULL,
	[Fecha] [nvarchar](50) NOT NULL,
	[Id_Administrador] [int] NOT NULL,
	[Id_Forma_de_Pago] [int] NOT NULL,
	[Costo_Total] [float] NOT NULL,
 CONSTRAINT [PK_Factura] PRIMARY KEY CLUSTERED 
(
	[Num_Factura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Formas_de_Pagos]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Formas_de_Pagos](
	[Id_Pago] [int] IDENTITY(1,1) NOT NULL,
	[Pago] [nvarchar](50) NULL,
 CONSTRAINT [PK_Formas_de_Pagos] PRIMARY KEY CLUSTERED 
(
	[Id_Pago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Noticias]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Noticias](
	[Id_Noticia] [int] IDENTITY(1,1) NOT NULL,
	[Noticia] [nvarchar](max) NOT NULL,
	[Id_Actividad] [int] NOT NULL,
	[Activo] [bit] NULL,
	[Titulo] [nvarchar](50) NULL,
 CONSTRAINT [PK_Noticias] PRIMARY KEY CLUSTERED 
(
	[Id_Noticia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Socios]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Socios](
	[Id_Socio] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[Apellido] [nvarchar](50) NOT NULL,
	[DNI] [int] NOT NULL,
	[Activo] [bit] NULL,
 CONSTRAINT [PK_Socios] PRIMARY KEY CLUSTERED 
(
	[Id_Socio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Actividad_x_Socio]  WITH CHECK ADD  CONSTRAINT [FK_Actividad_x_Socio_Actividades] FOREIGN KEY([Id_Actividad])
REFERENCES [dbo].[Actividades] ([Id_Actividad])
GO
ALTER TABLE [dbo].[Actividad_x_Socio] CHECK CONSTRAINT [FK_Actividad_x_Socio_Actividades]
GO
ALTER TABLE [dbo].[Actividad_x_Socio]  WITH CHECK ADD  CONSTRAINT [FK_Actividad_x_Socio_Socios] FOREIGN KEY([Id_Socio])
REFERENCES [dbo].[Socios] ([Id_Socio])
GO
ALTER TABLE [dbo].[Actividad_x_Socio] CHECK CONSTRAINT [FK_Actividad_x_Socio_Socios]
GO
ALTER TABLE [dbo].[Detalle_Factura]  WITH CHECK ADD  CONSTRAINT [FK_Detalle_Factura_Actividades] FOREIGN KEY([Id_Actividades])
REFERENCES [dbo].[Actividades] ([Id_Actividad])
GO
ALTER TABLE [dbo].[Detalle_Factura] CHECK CONSTRAINT [FK_Detalle_Factura_Actividades]
GO
ALTER TABLE [dbo].[Detalle_Factura]  WITH CHECK ADD  CONSTRAINT [FK_Detalle_Factura_Factura] FOREIGN KEY([Id_Factura])
REFERENCES [dbo].[Factura] ([Num_Factura])
GO
ALTER TABLE [dbo].[Detalle_Factura] CHECK CONSTRAINT [FK_Detalle_Factura_Factura]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Administrador] FOREIGN KEY([Id_Administrador])
REFERENCES [dbo].[Administrador] ([Id_Administrador])
GO
ALTER TABLE [dbo].[Factura] CHECK CONSTRAINT [FK_Factura_Administrador]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Formas_de_Pagos] FOREIGN KEY([Id_Forma_de_Pago])
REFERENCES [dbo].[Formas_de_Pagos] ([Id_Pago])
GO
ALTER TABLE [dbo].[Factura] CHECK CONSTRAINT [FK_Factura_Formas_de_Pagos]
GO
ALTER TABLE [dbo].[Noticias]  WITH CHECK ADD  CONSTRAINT [FK_Noticias_Actividades] FOREIGN KEY([Id_Actividad])
REFERENCES [dbo].[Actividades] ([Id_Actividad])
GO
ALTER TABLE [dbo].[Noticias] CHECK CONSTRAINT [FK_Noticias_Actividades]
GO
/****** Object:  StoredProcedure [dbo].[CONSULTAR_FORMAS_DE_PAGO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[CONSULTAR_FORMAS_DE_PAGO]
AS
SELECT * FROM Formas_de_Pagos
GO
/****** Object:  StoredProcedure [dbo].[UP_ACTIVAR_PUBLICACION]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ACTIVAR_PUBLICACION]
@ID_NOTICIA INT 
AS 

DECLARE @ACTIVADO INT
SET @ACTIVADO = 1 

UPDATE Noticias
SET Activo = @ACTIVADO
WHERE Id_Noticia = @ID_NOTICIA
GO
/****** Object:  StoredProcedure [dbo].[UP_ACTIVIDAD_X_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ACTIVIDAD_X_SOCIO]
@ID_ACTIVIDAD INT ,
@ID_SOCIO INT
AS 

DECLARE @ACTIVO BIT
SET @ACTIVO = 1

INSERT INTO Actividad_x_Socio VALUES(@ID_ACTIVIDAD,@ID_SOCIO,@ACTIVO)
GO
/****** Object:  StoredProcedure [dbo].[UP_ACTIVIDADES_CON_MAS_GANANCIAS]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ACTIVIDADES_CON_MAS_GANANCIAS]
AS
SELECT TOP 3 SUM(MONTO_UNITARIO) AS'MONTO',A.Actividad
FROM  Detalle_Factura DF, Actividades A
WHERE DF.Id_Actividades = A.Id_Actividad
GROUP BY Id_Actividades ,A.Actividad
ORDER BY SUM(MONTO_UNITARIO) DESC
GO
/****** Object:  StoredProcedure [dbo].[UP_ACTUALIZAR_ACTIVIDAD]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ACTUALIZAR_ACTIVIDAD]
@NOMBRE NVARCHAR(50),
@PRECIO FLOAT ,
@ID INT
AS 
UPDATE ACTIVIDADES 
SET Actividad = @NOMBRE,
Precio  = @PRECIO
WHERE Id_Actividad  = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_ACTUALIZAR_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ACTUALIZAR_SOCIO]
@ID INT ,
@NOMBRE NVARCHAR(50),
@APELLIDO NVARCHAR(50),
@DNI INT
AS
UPDATE Socios 
SET NOMBRE = @NOMBRE ,
Apellido = @APELLIDO ,
DNI = @DNI 
WHERE Id_Socio = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_AGREGAR_ACTIVIDAD]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_AGREGAR_ACTIVIDAD]
@NOMBRE NVARCHAR(50),
@PRECIO FLOAT 
AS 
DECLARE @ACTIVO BIT
SET @ACTIVO = 1
INSERT INTO Actividades VALUES(@NOMBRE,@PRECIO,@ACTIVO)
GO
/****** Object:  StoredProcedure [dbo].[UP_AGREGAR_FACTURA]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_AGREGAR_FACTURA] 
@ID_SOCIO INT ,
@ID_FORMA_DE_PAGO INT

AS
DECLARE @FECHA DATETIME
SET @FECHA = GETDATE()

DECLARE @ID_ADMINISTRADOR INT
SET @ID_ADMINISTRADOR =(SELECT Id_Administrador FROM Administrador)

DECLARE @INT INT = (SELECT MIN(AC.Id_Actividad) 
                    from Actividad_x_Socio AC , Actividades A 
                    WHERE AC.Id_Actividad = A.Id_Actividad
                    AND AC.Id_Socio = @ID_SOCIO
                    AND AC.Activo= 1)
DECLARE @INT2 INT = (SELECT MAX(AC.Id_Actividad) 
                    from Actividad_x_Socio AC , Actividades A 
                    WHERE AC.Id_Actividad = A.Id_Actividad
                    AND AC.Id_Socio = @ID_SOCIO
                    AND AC.Activo= 1)

DECLARE @cnt INT = @INT;


DECLARE @MONTO_TOTAL FLOAT
SET @MONTO_TOTAL =( SELECT sum(precio)
                    from Actividades a , Actividad_x_Socio ac
                    where a.Id_Actividad = ac.Id_Actividad
					and ac.Id_Socio = @ID_SOCIO
					and ac.Activo =1
                    and a.Id_Actividad between @INT and @INT2)
PRINT(@MONTO_TOTAL)


INSERT INTO Factura VALUES(@ID_SOCIO,@FECHA,@ID_ADMINISTRADOR,@ID_FORMA_DE_PAGO,@MONTO_TOTAL)

DECLARE @ID_FACTURA INT
SET @ID_FACTURA = (Select @@IDENTITY)

WHILE  @cnt <= @INT2
BEGIN

DECLARE @ID INT 
SET @ID =(
     select id_actividad
     from Actividad_x_Socio 
     where Id_Socio = @ID_SOCIO   
     and Id_Actividad = @INT)

DECLARE @MONTO FLOAT 
SET @MONTO =(
     select precio
     from Actividad_x_Socio Ac , Actividades A
     where Ac.Id_Actividad = a.Id_Actividad
	 and Id_Socio = @ID_SOCIO   
     and Ac.Id_Actividad = @INT)

	 IF @ID >= 0
	 BEGIN
	 	 INSERT INTO Detalle_Factura VALUES(@ID_FACTURA,@ID,@MONTO)
	 END
	 ELSE 
	 BEGIN
	     PRINT('NO HAY ID PARA INSERTAR , PASO AL SIGUIENTE')
	 END


   SET @cnt = @cnt + 1;
   SET @INT = @INT + 1;
END;
GO
/****** Object:  StoredProcedure [dbo].[UP_AGREGAR_PUBLICACION]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[UP_AGREGAR_PUBLICACION]
@NOTICIA NVARCHAR(MAX),
@ID_ACTIVIDAD INT ,
@TITULO NVARCHAR(50)
AS

DECLARE @ACTIVO BIT 
set @ACTIVO = 1

INSERT INTO Noticias VALUES(@NOTICIA,@ID_ACTIVIDAD,@ACTIVO,@TITULO)
GO
/****** Object:  StoredProcedure [dbo].[UP_AGREGAR_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_AGREGAR_SOCIO]
@NOMBRE NVARCHAR(50),
@APELLIDO NVARCHAR(50),
@DNI INT
AS

DECLARE @ACTIVO BIT
SET @ACTIVO = 1

DECLARE @REGISTRADO INT
SET @REGISTRADO = (SELECT DNI FROM SOCIOS WHERE DNI = @DNI)

IF @REGISTRADO = @DNI

BEGIN

PRINT ('EL USUARIO YA ESTA REGISTRADO')

END

ELSE

BEGIN

INSERT INTO SOCIOS VALUES(@NOMBRE,@APELLIDO,@DNI,@ACTIVO)

END
GO
/****** Object:  StoredProcedure [dbo].[UP_BAJA_DE_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_BAJA_DE_SOCIO]
@ID INT
AS
UPDATE Socios
SET ACTIVO = 0
WHERE Id_Socio = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_CONSULTAR_SOCIO_EN_PARTICULAR]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_CONSULTAR_SOCIO_EN_PARTICULAR]
@ID INT
AS 

SELECT * 
FROM Socios 
WHERE Id_Socio = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_CONSULTAR_SOCIO_EN_PARTICULAR_POR_DNI]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_CONSULTAR_SOCIO_EN_PARTICULAR_POR_DNI]
@DNI INT = 0
AS 

SELECT * 
FROM Socios 
WHERE DNI = @DNI
AND ACTIVO = 1
GO
/****** Object:  StoredProcedure [dbo].[UP_CONSULTAR_SOCIOS_ACTIVOS]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_CONSULTAR_SOCIOS_ACTIVOS]
AS 

SELECT * 
FROM Socios 
WHERE ACTIVO = 1
GO
/****** Object:  StoredProcedure [dbo].[UP_CONSULTAR_SOCIOS_INACTIVOS]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_CONSULTAR_SOCIOS_INACTIVOS]
AS 

SELECT * 
FROM Socios 
WHERE ACTIVO = 0
GO
/****** Object:  StoredProcedure [dbo].[UP_CUOTAS_PAGADAS_DE_UN_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_CUOTAS_PAGADAS_DE_UN_SOCIO]
@ID INT 
AS
SELECT CONVERT(VARCHAR(12),F.Fecha)as 'FECHA', F.COSTO_TOTAL
FROM FACTURA F
WHERE F.Id_Socio = @ID
ORDER BY F.FECHA DESC
GO
/****** Object:  StoredProcedure [dbo].[UP_DESACTIVAR_PUBLICACION]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_DESACTIVAR_PUBLICACION]
@ID_NOTICIA INT 
AS 

DECLARE @ACTIVADO INT
SET @ACTIVADO = 0 

UPDATE Noticias
SET Activo = @ACTIVADO
WHERE Id_Noticia = @ID_NOTICIA
GO
/****** Object:  StoredProcedure [dbo].[UP_DESCATICVAR_ACTIVIDAD_X_SOCIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[UP_DESCATICVAR_ACTIVIDAD_X_SOCIO]
@ID_SOCIO INT  ,
@ID_ACTIVIDAD INT
AS

DECLARE @ACTIVO BIT
SET @ACTIVO = 0

UPDATE Actividad_x_Socio
SET Activo = @ACTIVO
WHERE Id_Socio = @ID_SOCIO
AND Id_Actividad = @ID_ACTIVIDAD
GO
/****** Object:  StoredProcedure [dbo].[UP_ELIMINAR_ACTIVIDAD]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_ELIMINAR_ACTIVIDAD]
@ID INT
AS
UPDATE ACTIVIDADES 
SET ACTIVO= 0
WHERE Id_Actividad  = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_NOTICIAS]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--SELECT DE NOTICIAS INVITADO
CREATE PROCEDURE [dbo].[UP_NOTICIAS]
AS
SELECT N.Activo, N.Noticia,N.Id_Noticia , Titulo ,A.Actividad ,A.Id_Actividad
FROM Noticias N , Actividades A 
WHERE N.Id_Actividad = A.Id_Actividad
AND N.Activo = 1
ORDER BY Id_Noticia DESC
GO
/****** Object:  StoredProcedure [dbo].[UP_NOTICIAS_EN_PARTIULAR]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_NOTICIAS_EN_PARTIULAR]
@ID INT
AS
SELECT N.Activo,Id_Noticia , Noticia , Titulo ,A.Actividad ,A.Id_Actividad
FROM Noticias N , Actividades A 
WHERE N.Id_Actividad = A.Id_Actividad
AND N.Activo = 1
AND A.Id_Actividad =@ID
GO
/****** Object:  StoredProcedure [dbo].[UP_SELECCIONAR_ACTIVIDAD_DE_UNA_PERSONA]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_SELECCIONAR_ACTIVIDAD_DE_UNA_PERSONA]
@ID INT
AS
SELECT AC.Id_Actividad , AC.Id_Socio , A.Actividad  , S.Nombre , S.Apellido ,S.DNI
FROM Actividad_x_Socio AC , Actividades A , Socios S
WHERE AC.Id_Actividad = A.Id_Actividad
AND AC.Id_Socio = S.Id_Socio
AND AC.ACTIVO = 1
AND S.Activo = 1
AND A.Activo = 1
AND S.Id_Socio = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_SOCIOS_DE_UNA_ACTIVIDAD]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_SOCIOS_DE_UNA_ACTIVIDAD]
@ID INT 
AS
SELECT A.Actividad , S.Nombre , S.Apellido  , S.DNI
FROM Actividades A , Actividad_x_Socio AC , Socios S
WHERE A.Id_Actividad = AC.Id_Actividad 
AND AC.Id_Socio = S.Id_Socio
AND AC.Activo = 1 
AND A.Activo = 1
AND A.Id_Actividad = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_TODAS_LAS_NOTICIAS]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_TODAS_LAS_NOTICIAS]
AS
SELECT N.Activo,N.Id_Noticia, Noticia , Titulo ,A.Actividad ,A.Id_Actividad
FROM Noticias N , Actividades A 
WHERE N.Id_Actividad = A.Id_Actividad
ORDER BY Id_Noticia DESC
GO
/****** Object:  StoredProcedure [dbo].[UP_TOTAL_A_PAGAR_POR_USUARIO]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_TOTAL_A_PAGAR_POR_USUARIO]
@ID INT
AS
SELECT SUM(PRECIO) AS'PRECIO TOTAL A PAGAR',AC.Id_Socio, S.Nombre ,S.Apellido,S.DNI
FROM ACTIVIDADES A , Actividad_x_Socio AC , Socios S 
WHERE A.Id_Actividad = AC.Id_Actividad
AND AC.Id_Socio = S.Id_Socio
AND S.Activo = 1
AND A.Activo = 1
AND AC.Activo =1
AND AC.Id_Socio = @ID  --PRIMER VARIABLE
GROUP BY  AC.Id_Socio ,S.Nombre ,S.Apellido,S.DNI
GO
/****** Object:  StoredProcedure [dbo].[UP_TRAER_ACTIVIDAD_EN_PARTICULAR]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_TRAER_ACTIVIDAD_EN_PARTICULAR]
@ID INT
AS
SELECT * 
FROM ACTIVIDADES 
WHERE Id_Actividad = @ID
GO
/****** Object:  StoredProcedure [dbo].[UP_TRAER_ACTIVIDAD_EN_PARTICULAR_POR_NOMBRE]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_TRAER_ACTIVIDAD_EN_PARTICULAR_POR_NOMBRE]
@NOMBRE NVARCHAR(50)
AS
SELECT * 
FROM ACTIVIDADES 
WHERE Actividad = @NOMBRE
AND ACTIVO = 1
GO
/****** Object:  StoredProcedure [dbo].[UP_TRAER_ACTIVIDADES]    Script Date: 28/10/2020 19:04:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UP_TRAER_ACTIVIDADES]
AS
SELECT * 
FROM ACTIVIDADES 
WHERE ACTIVO = 1
GO
USE [master]
GO
ALTER DATABASE [Club] SET  READ_WRITE 
GO
