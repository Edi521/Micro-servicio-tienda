DROP TABLE EMPLEADO_TIENDA;
CREATE TABLE EMPLEADO_TIENDA(
    ID_EMPLEADO NUMBER,
    NOMBRE NVARCHAR2(100),
    APP NVARCHAR2(100),
    TELEFONO NUMBER,
    PUESTO NVARCHAR2(100),
    TIENDA_ID NUMBER,
    CONSTRAINT EMPLEADO_TIENDA_PK PRIMARY KEY(ID_EMPLEADO)
);

INSERT INTO EMPLEADO_TIENDA VALUES(1,'EDUARDO','SÁNCHEZ',5574081594,'GERENTE',1);

COMMIT;

SELECT * FROM EMPLEADO_TIENDA;