from fastapi import FastAPI
from typing import List
from fastapi.params import Depends
from sqlalchemy.orm.session import Session
from starlette.responses import RedirectResponse
import modelos
import schema
from Conexion import SessionLocal,engine

modelos.Base.metadata.create_all(bind=engine)

app = FastAPI()

def get_db():
    try:
        db=SessionLocal()
        yield db
    finally:
        db.close()
        
@app.get("/")
def main():
    return RedirectResponse(url="/docs/")

@app.get("/listar-usuarios",response_model=List[schema.Usuario])
def listar_usuarios(db:Session = Depends(get_db)):
    usuarios=db.query(modelos.Usuario).all()
    return usuarios


@app.post('/usuarios',response_model=schema.Usuario)
def crear_usuarios(entrada:schema.Usuario,db:Session = Depends(get_db)):
	usuario=modelos.Usuario(username=entrada.username,nombre=entrada.nombre,rol=entrada.rol,estado=entrada.estado)
	db.add(usuario)
	db.commit()
	db.refresh(usuario)
	return usuario

@app.put('/usuarios/{usuario_id}',response_model=schema.Usuario)
def actualizar_usuario(usuario_id:int,entrada:schema.UsuarioUpdate, db:Session = Depends(get_db)):
	usuario = db.query(modelos.Usuario).filter_by(id=usuario_id).first()
	usuario.nombre = entrada.nombre
	db.commit()
	db.refresh(usuario)
	return usuario

@app.delete('/eliminar-usuario/{usuario_id}')
def eliminar_usuario( usuario_id:int,db:Session = Depends(get_db)):
    usuario = db.query(modelos.Usuario).filter_by(id=usuario_id).first()
    db.delete(usuario)
    db.commit()

    return 'Eliminado exitosamente'
