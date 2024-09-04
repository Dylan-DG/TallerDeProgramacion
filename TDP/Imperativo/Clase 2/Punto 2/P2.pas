program P2;

type
  lista =^nodo;
  nodo = record
    dato:integer;
    sig:lista;
  end;
  
procedure agregarAdelante(var l: lista; num: integer);
var
    nuevo: lista;
begin
    new(nuevo);
    nuevo^.dato:= num;
    nuevo^.sig:= l;
    l:= nuevo;
end;

procedure crearLista(var L:lista);
var
  num:integer;
begin
  num:=random(101)+100;
  if(num <>100)then
  begin
    agregarAdelante(L,num);
    crearLista(L);
  end;
end;

procedure imprimirRecursivoInverso(L:lista); //imprime los datos al reves de como fueron ingresados
begin
  if(L<>nil)then
  begin
    imprimirRecursivo(L^.sig);
    writeln(L^.dato);
  end;
end;

procedure imprimirRecursivo(L:lista); //imprime los datos de la lista en el orden ingresado
begin
  if(L<>nil)then
  begin
    writeln(L^.dato);
    imprimirRecursivo(L^.sig);
  end;
end;

function minimo(L:lista):integer; //obtiene el minimo de la lista generado
var
  min:integer;
begin
  min:=300;
  if(L<>nil)then
  begin
    min:=minimo(L^.sig);
    
    if(L^.dato<min)then
      min:=L^.dato;
  end;
  minimo:=min;
end;

function busqueda(L:lista;num:integer):boolean;
begin
  if(L<>nil)then
  begin
    if(L^.dato = num)then
      busqueda:=true
    else
      busqueda:=busqueda(L^.sig,num);
  end
  else
    busqueda:=false;
end;

var
  L,ult:lista;
  min:integer;
begin
  L:=nil;
  crearLista(L);
  imprimirRecursivo(L);
  //imprimirRecursivoInverso(L);
  //min:=minimo(L);
  //writeln('el minimo es: ',min);

  if (busqueda(l, 150)) then
    writeln('El valor 150 se encuentra en la lista')
  else
    writeln('El valor 150 no se encuentra en la lista');
end.