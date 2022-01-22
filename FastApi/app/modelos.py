from Conexion import Base
from sqlalchemy.sql.schema import Column
from sqlalchemy.sql.sqltypes import Integer,String

class Usuario(Base):
    __tablename__ ='usuario'
    id = Column(Integer, primary_key=True, index=True)
    username=Column(String(20))
    nombre=Column(String(200))
    rol=Column(String(20))
    estado = Column(Integer)
