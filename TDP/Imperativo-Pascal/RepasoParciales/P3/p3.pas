program p3;
const
	dimF = 6;
type
	atencion= record
		matricula:integer;
		dni:integer;
		dia:integer;
		diagnostico:char;
	end;
	
	dato = record
		matricula:integer;
		cant:integer;
	end;
    arbol =^nodo;
    nodo= record
		dato:dato;
		HI:arbol;
		HD:arbol;
    end;
    
    lista=^n2;
    n2=record
		dni:integer;
		sig:lista;
    end;
    generos = record
		tipoGenero:char;
		dni:lista;
    end;
    vector=array [1..dimF] of generos;

procedure leerAtencion(var a:atencion);
var
	v: array[1..6] of char = ('a','b','c','d','e','f');
begin
	a.dni:=random(5000);
	if(a.dni <>0)then
	begin
		a.matricula:= random(1000)+2000;
		a.dia:=random(31)+1;
		a.diagnostico:=v[random(6)+1];
	end;
end;

procedure agregarArbol(var a:arbol;dato:atencion);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.matricula:=dato.matricula;
		a^.dato.cant:=1;
		a^.HI:=nil;
		a^.HD:=nil;
	end
	else
	begin
		if(a^.dato.matricula = dato.matricula)then
			a^.dato.cant:=a^.dato.cant +1
		else
		begin
			if(a^.dato.matricula > dato.matricula)then
				agregarArbol(a^.HI,dato)
			else 
				agregarArbol(a^.HD,dato);
		end;
	end;
end;

procedure inicializarVector(var v:vector);
var
	i:integer;
	a: array[1..6] of char = ('a','b','c','d','e','f');
begin
	for i:=1 to 6 do
	begin
		v[i].tipoGenero:=a[i];
		v[i].dni :=nil;
	end;
end;

procedure agregarVector(var v:vector;dato:atencion);
var 
	i:integer;
	aux:lista;
begin
	for i:=1 to 6 do
	begin
		if(v[i].tipoGenero = dato.diagnostico)then
		begin
			new(aux);
			aux^.dni:=dato.dni;
			aux^.sig:=v[i].dni;
			v[i].dni:=aux;
		end;
	end;
end;

procedure cargarEstructuras(var a:arbol;var v:vector);
var
	dato:atencion;
begin
	a:=nil;
	inicializarVector(v);
	leerAtencion(dato);
	while(dato.dni <> 0)do
	begin
		agregarArbol(a,dato);
		agregarVector(v,dato);
		leerAtencion(dato);
	end;
end;

procedure busquedaMatricula(a:arbol;m:integer;var cant:integer);
begin
	if(a<>nil)then
	begin
		if(a^.dato.matricula> m)then
			cant:=cant + a^.dato.cant;
		busquedaMatricula(a^.HI,m,cant);
		busquedaMatricula(a^.HD,m,cant);
	end;
end;

procedure recorrerLista(v:lista;var cant:integer);
begin
	if(v<>nil)then
	begin
		cant:=cant +1;
		recorrerLista(v^.sig,cant);
	end;
end;

procedure recorrerVector(v:vector;var diagnostico:char;max:integer;dimL:integer);
var
	cant:integer;
begin
	cant:=0;
	if(dimL<>0)then
	begin
		recorrerLista(v[dimL].dni,cant);
		if(max < cant)then
		begin
			max := cant;
			diagnostico:=v[dimL].tipoGenero;
		end;
		recorrerVector(v,diagnostico,max,dimL-1);
	end;
end;

var
	a:arbol;
	v:vector;
	cant,matricula:integer;
	diagnostico:char;
	max:integer;
begin
	randomize;
	cant:=0;
	max:=0;
	
	cargarEstructuras(a,v);
	readln(matricula);
	busquedaMatricula(a,matricula,cant);
	recorrerVector(v,diagnostico,max,dimF);
end.
