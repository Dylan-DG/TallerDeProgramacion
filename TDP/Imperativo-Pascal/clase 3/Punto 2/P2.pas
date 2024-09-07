program p2;
const
  meses = 12;
  dias = 30;
type
  mes = 1..meses;
  dia = 1..dias;

  fecha = record
    dia:dia;
    mes:mes;
  end;
  ventas=record
    codigo:integer;
    fecha:fecha;
    cantVendidas: integer;
  end;

  arbol=^nodo;
  nodo = record
    dato:ventas;
    HI:arbol;
    HD:arbol;
  end;

  v2 = record
    codigoDeProducto:integer;
    cantTotalVendidas:integer
  end;

  arbol2 = ^n2;
  n2 = record
    dato:v2;
    HI:arbol2;
    HD:arbol2;
  end;

  lista = ^NodoLista;
  NodoLista = record
    dato:ventas;
    sig:lista;
  end;

  arbolLista=^n3;
  n3 = record
    dato:lista;
    HI:arbolLista;
    HD:arbolLista;
  end;

procedure inicializarArboles(var a:arbol;var c:arbolLista;var b:arbol2);
begin
  a:=nil;
  b:=nil;
  c:=nil;
end;

procedure cargarDatos(var dato:ventas);
begin
  write('ingrese el codigo: ');
  dato.codigo:=random(31);
  writeln(dato.codigo);

  write('ingresa la fecha de la venta: ');
  dato.fecha.dia:=random(dias)+1;
  dato.fecha.mes:=random(meses)+1;
  write(dato.fecha.dia,'/');
  write(dato.fecha.mes);
  writeln();

  write('ingrese la cantidad de ventas: ');
  dato.cantVendidas:=random(100);
  writeln(dato.cantVendidas);
end;

procedure agregar1(var A:arbol;dato:ventas);
begin
  if (A = nil) then
  begin
    new(A);
    A^.dato:=dato;
    A^.HI:=nil;
    A^.HD:=nil;
  end
  else
  begin
    if(dato.codigo < A^.dato.codigo)then
      agregar1(A^.HI,dato)
    else
      agregar1(A^.HD,dato);
  end;
end;

procedure agregar2(var b:arbol2; codigo,cantVendidas:integer);
begin
  if(b=nil)then begin
    new(b);
    b^.dato.codigoDeProducto:=codigo;
    b^.dato.cantTotalVendidas:=cantVendidas;
    b^.HI:=nil;
    b^.HD:=nil;
  end
  else begin
    if(codigo = b^.dato.codigoDeProducto)then
      b^.dato.cantTotalVendidas:=b^.dato.cantTotalVendidas + cantVendidas
    else begin
      if(codigo < b^.dato.codigoDeProducto)then
        agregar2(b^.HI,codigo,cantVendidas)
      else
        agregar2(b^.HD,codigo,cantVendidas);
    end;
  end;
end;

procedure crearNodoLista(var L:lista;dato :ventas); //agrega los nodos de forma recursiva
begin
  if(L = nil)then
  begin
    new(L);
    L^.dato:=dato;
    L^.sig:=nil;
  end
  else
    crearNodoLista(L^.sig,dato);
end;

procedure agregar3(var c:arbolLista;dato:ventas);
begin
  if(c = nil)then begin
    new(c);
    crearNodoLista(c^.dato,dato);
    c^.HI:=nil;
    c^.HD:=nil;
  end
  else begin
    if(dato.codigo = c^.dato^.dato.codigo)then
      crearNodoLista(c^.dato,dato)
    else begin
      if(dato.codigo < c^.dato^.dato.codigo) then
        agregar3(c^.HI,dato)
      else
        agregar3(c^.HD,dato);
    end;
  end;
end;

procedure armarArboles(var a:arbol;var c:arbolLista;var b:arbol2);
var
  datos:ventas;
begin
  cargarDatos(datos);
  while(datos.codigo <> 0)do
  begin
    agregar3(c,datos);
    agregar2(b,datos.codigo,datos.cantVendidas);
    agregar1(a,datos);
    cargarDatos(datos);
  end;
end;

procedure cantTotalProductos( a:arbol;fecha:fecha;var cant :integer);
begin
  if (a <> nil) then
  begin
    if (a^.dato.fecha.dia = fecha.dia)and (a^.dato.fecha.mes = fecha.mes) then
      cant:= cant + a^.dato.cantVendidas;
    cantTotalProductos(a^.HI, fecha, cant);
    cantTotalProductos(a^.HD, fecha, cant);
  end;
end;

procedure maxVentas(a: arbol2; var cantMax: integer; var cod: integer);
begin
  if (a <> nil) then
  begin
    if (a^.dato.cantTotalVendidas > cantMax) then
    begin
      cantMax:= a^.dato.cantTotalVendidas;
      cod:= a^.dato.codigoDeProducto;
    end;
    maxVentas(a^.HI, cantMax, cod);
    maxVentas(a^.HD, cantMax, cod);
  end;
end;

procedure recorrerLista(L:lista;var cantTotal,cod:integer);
var
  cant:integer;
begin
  cant:= 0;
  while(L<>nil) do
  begin
    cant:= cant + 1;
    L:= L^.sig;
  end;
  if (cant > cantTotal) then
  begin
    cantTotal:= cant;
    cod:= L^.dato.codigo;
  end;
end;

procedure mayorCantidadVentas(c:arbolLista; var cantMax,codMax:integer);
begin
  if (c <> nil) then
  begin
    recorrerLista(c^.dato,cantMax,codMax);
    mayorCantidadVentas(c^.HI, cantMax, codMax);
    mayorCantidadVentas(c^.HD, cantMax, codMax);
  end;
end;

var
  a:arbol;
  b:arbol2;
  c:arbolLista;
  fe:fecha;
  cant,cantmax,codeMax:integer;
  Cmax,cod:integer;
begin
  randomize;
  cant:=0;
  cantMax:=0;
  Cmax:=0;

  inicializarArboles(a,c,b);
  armarArboles(a,c,b);

  writeln('ingresa una fecha');
  write('ingresa dia: ');
  read(fe.dia); 
  write('ingresa mes: '); 
  read(fe.mes);
  cantTotalProductos(a,fe,cant);
  writeln('la cantidad total de productos vendidos en esa fecha es de: ',cant);

  maxVentas(b,cantmax,codeMax);
  writeln('el codigo de producto con la mayor cantidad de unidades vendidas es: ',codeMax);

  mayorCantidadVentas(c,Cmax,cod);
  write('el codigo con la mayor cantidad de ventas es: ',cod);
  
end.