program P3;
const
	dimF = 8;
type
	gene = 1..dimF;
	
	pelicula = record	//registro de datos de la pelicula.
		codigoDePelicula: integer;
		codigoDeGenero: integer;
		puntaje: integer;
	end;
	lista = ^nodo;		//lista para las peliculas con sus respectivos registro.
	nodo = record
		datos: pelicula;
		sig: lista;
	end;

	puntajes = record //registro para almacenar los puntajes maximos junto al codigo de la pelicula con ese puntaje.
		codigo : integer;
		puntaje: integer;
		Name : string;
	end;

	generos = array[1..dimF] of puntajes;  //array de los maximos puntajes para cada genero  î.

procedure ordenarSeleccion(var v:generos); //ordena el vector por puntaje mas alto por el algoritmo de seleccion.
var
	i,j,pos:gene;
	item:puntajes;
begin
	for i := 1 to dimF-1 do //ordena todo
	begin
		pos:=i;

		for j:= i+1 to dimF do 	//busca un numero mas pequeño para guardar la posicion
		begin
			if(v[j].puntaje< v[pos].puntaje)then
				pos:= j;
		end;

		item:= v[pos]; //se intercambian los datos.
		v[pos]:=v[i];
		v[i]:=item;
	end;
end;

procedure maximos(var v:generos; info:pelicula); //obtiene los puntajes maximos de cada genero y se almacenan en el vector junto al codigo de la pelicula
begin
	if(info.puntaje > v[info.codigoDeGenero].puntaje) then
	begin
		v[info.codigoDeGenero].puntaje:= info.puntaje;
		v[info.codigoDeGenero].codigo:= info.codigoDePelicula; 
	end;
end;
	
procedure llenarArray(var v:generos); //llena el array con numeros pequeños para poder compararlos.
var
	i:integer;
begin
	for i := 1 to dimF do
	begin
		v[i].puntaje:= 0;
		v[i].codigo:=0;
	end;
	
	v[1].Name := 'accion';
	v[2].Name := 'aventura';
	v[3].Name := 'drama';
	v[4].Name := 'suspenso';
	v[5].Name := 'comedia';
	v[6].Name := 'belico';
	v[7].Name := 'documental';
	v[8].Name := 'terror';
end;

procedure imprimirVector(v : generos); //imprimer el vector de maximos para verificar.
var
	i:integer;
begin
	for i:=1 to dimF do
	begin
		writeln('el codigo de la pelicula es: ',v[i].codigo);
		writeln('puntaje maximo es: ',v[i].puntaje);
	end;
end;

procedure imprimir(L:lista); //imprimer la lista para verificar como se guardo.
begin
	while(L<>nil)do
	begin
		writeln(L^.datos.codigoDePelicula);
		L:=L^.sig;
	end;
end;

procedure armarNodo(var L,ult:lista; dato:pelicula); //genera un nuevo nodo y le carga los datos(se posiciona en ordden de llegada). 
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos := dato;
	nuevo^.sig:=nil;
	if (L=nil) then
	begin
		L:=nuevo;
		ult:=nuevo;
	end
	else
	begin
		ult^.sig:=nuevo;
		ult:=nuevo;
	end;
end;
procedure cargarDatos(var dato:pelicula); //carga de datos para el nodo algunos son randoms para ahorrar tiempo.
begin
	Randomize;

	write('ingrese codigo de pelicula: ');
	readln(dato.codigoDePelicula);

	write('ingrese el codigo de genero: ');
	readln(dato.codigoDeGenero);
	{dato.codigoDeGenero:=Random(9);
	writeln(dato.codigoDeGenero);}

	write('ingrese el puntaje promedio de la pelicula: ');
	dato.puntaje:= Random(11);
	writeln(dato.puntaje);
end;

procedure crearLista(var ult,L:lista; var v:generos); //crea la lista y obtiene algunos datos.
var
	info:pelicula;
	generoA: integer;
begin
	cargarDatos(info);

	while(info.codigoDePelicula <>-1)do
	begin
		generoA:= info.codigoDeGenero;

		while(info.codigoDeGenero = generoA) and(info.codigoDePelicula <> -1 ) do
		begin
			maximos(v,info);
			armarNodo(L,ult,info);
			cargarDatos(info);
		end;
	end;
	ordenarSeleccion(v);
end;

var
	ult,L:lista;
	v: generos;
begin
	llenarArray(v);
	crearLista(ult,L,v);
	imprimir(L);
	imprimirVector(v);
end.