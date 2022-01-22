from pydantic import BaseModel
from typing import Optional

class Usuario(BaseModel):
    id:Optional[int]
    username:str
    nombre:str
    rol:str
    estado:int
    
    class Config():
        orm_mode = True


class UsuarioUpdate(BaseModel):
	nombre:str
	class Config:
		orm_mode=True