program P4;
const
  dimF = 8;
type
  rubro = 1..dimF;

  producto = record
    codigoDeProducto: integer;
    codigoDeRubro: rubro;
    precio: real;
  end;

  lista = ^nodo;
  nodo = record
    datos: producto;
    sig: lista;
  end;

  libreria = array[rubro] of lista; 

procedure imprimirLista(lib:libreria);
var
  i:rubro;
begin
  for i := 1 to dimF do
  begin
    while(lib[i] <>nil)do
    begin
      writeln(lib[i]^.datos.codigoDeProducto);
      lib[i]:=lib[i]^.sig;
    end;
  end;
end;

procedure cargarDatos(var datos:producto); //carga valores aleatorios o cargados por teclado
begin
  randomize;

  write('ingrese el codigo de producto: ');
  //readln(datos.codigoDeProducto);
  datos.codigoDeProducto:= Random(100);
  writeln(datos.codigoDeProducto);

  write('ingrese el codigo de rubro: ');
  readln(datos.codigoDeRubro);
  {datos.codigoDeRubro:= Random();
  writeln(datos.codigoDeRubro);}

  write('ingresa el precio del producto: ');
  readln(datos.precio);
  {datos.precio:= Random(100);
  writeln(datos.precio);}
end;

procedure crearNodo(var L:lista; datos:producto);//crea nodos con la forma de insertar ordenado
var
  nuevo:lista;
  act,ant:lista;
begin
  new(nuevo);
  nuevo^.datos:= datos;
  ant:=L;
  act:=L;
  while(act <> nil)and(datos.codigoDeProducto > act^.datos.codigoDeProducto)do
  begin
    ant:=act;
    act:=act^.sig;
  end;
  if (act = ant) then
  begin
    L:=nuevo;
  end
  else
    ant^.sig:=nuevo;
  nuevo^.sig:=act;
end;

procedure crearLista(var lib:libreria);
var
  datos: producto;
begin
  cargarDatos(datos);
  while(datos.precio <> 0)do
  begin
    crearNodo(lib[datos.codigoDeRubro],datos);
    cargarDatos(datos);
  end;
end;

var
  lib:libreria;

begin
  crearLista(lib); //punto c,d,e y f no los hice porque eran muy faciles 
  imprimirLista(lib);
end.            
