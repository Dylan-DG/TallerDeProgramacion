program P1;
const
	diasMax= 31;
	mesesMax=12;
	dimF= 12;
type
	dia = 1..diasMax;
	mes = 1..mesesMax;
	compras = record
		codVideojuego:integer;
		codCliente:integer;
		dia:dia;
		mes:mes;
	end;
	
	lista = ^n2;
	n2 = record
		dato:compras;
		sig:lista;
	end;
	
	cliente = record
		codCliente:integer;
		compras:lista;
	end;
	
    arbol = ^nodo;
    nodo = record
		dato:cliente;
		HI:arbol;
		HD:arbol;
    end;
    
    vector = array[1..dimF] of integer;

procedure leerCompra(var dato:compras);
begin
	dato.codCliente := Random(100);
	if(dato.codCliente <>0)then
	begin
		dato.codVideojuego:=random(20000)+1;
		dato.dia:=random(diasMax)+1;
		dato.mes:=random(mesesMax)+1;
	end;
end;

procedure agregarNodoLista(var l:lista; dato:compras);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.dato:=dato;
	nuevo^.sig:=l;
	l:=nuevo;
end;

procedure agregar(var a:arbol; dato:compras);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.codCliente:= dato.codCliente;
		agregarNodoLista(a^.dato.compras,dato);
		a^.HI:=nil;
		a^.HD:=nil;
	end
	else
	begin
		if(a^.dato.codCliente = dato.codCliente) then
			agregarNodoLista(a^.dato.compras,dato)
		else
		begin
			if(a^.dato.codCliente < dato.codCliente)then
				agregar(a^.HI,dato)
			else
				agregar(a^.HD,dato);
		end;
	end;
end;

procedure inicializarVector(var v:vector);
var 
	i:integer;
begin
	for i:=1 to mesesMax do
		v[i]:=0;
end;

procedure cargar(var a:arbol;var v:vector);
var
	dato:compras;
begin
	a:=nil;
	inicializarVector(v);
	
	leerCompra(dato);
	while(dato.codCliente <> 0)do
	begin
		v[dato.mes]:= v[dato.mes]+1;
		agregar(a,dato);
		leerCompra(dato);
	end;
end;

procedure buscarCompras(a:arbol;var cliente:lista;codigo:integer;ok:boolean);
begin
	if(a<>nil)and(ok)then
	begin
		if(a^.dato.codCliente = codigo)then
		begin
			cliente:=a^.dato.compras;
			ok:=false;
		end;
		buscarCompras(a^.HI,cliente,codigo,ok);
		buscarCompras(a^.HD,cliente,codigo,ok);
	end;
end;

procedure imprimirCompras(cli:lista);
begin
	if(cli<>nil)then
	begin
		writeln('codigo De Videojuego: ',cli^.dato.codVideojuego);
		writeln('mes: ',cli^.dato.mes);
		writeln('dia: ',cli^.dato.dia);
		imprimirCompras(cli^.sig);
	end;
end;

procedure imprimirVector(v:vector);
var
	i:integer;
begin
	for i:=1 to mesesMax do
		writeln(v[i]);
end;

procedure ordenarVector(var v:vector);
var
	i,j,pos:integer;
	item:integer;
begin
	for i:= 1 to mesesMax-1 do
	begin
		pos:=i;
		for j:=i+1 to mesesMax do
		begin
			if(v[pos]<v[j]) then
				pos:=j;
		end;
		item:=v[pos];
		v[pos]:=v[i];
		v[i]:=item;
	end;
end;

var
	a:arbol;
	v:vector;
	cli:lista;
	codigo:integer;
	ok:boolean;
begin
	ok:=true;
	randomize;
	
	cargar(a,v);
	write('ingrese un codigo a buscar: ');
	readln(codigo);
	buscarCompras(a,cli,codigo,ok);
	imprimirCompras(cli);
	ordenarVector(v);
	imprimirVector(v);
end.
