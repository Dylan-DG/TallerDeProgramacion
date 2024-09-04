program P3;
const
  dimF= 20;
type

  vector = array[1..dimF]of integer;

function cargarRecursivo(v:vector;dimL:integer):vector;
var
  num:integer;
begin
  num:=random(1549 - 300) + 301;
  if (dimL<=dimF) then
  begin
    v[dimL]:=num;
    v:=cargarRecursivo(v,dimL+1);
  end;
  cargarRecursivo:=v;
end;

procedure imprimirRecursivo(v:vector;dimL:integer);
begin
  if(dimL<=dimF)then
  begin
    writeln(v[dimL]);
    imprimirRecursivo(v,dimL+1);
  end;
end;

procedure ordenarVector(var v:vector;dimL:integer);
var
  i,j,pos,item:integer;
begin
  for i := 1 to dimL-1 do
  begin
    pos:=i;
    for j:=i+1 to dimL do
    begin
      if v[j] < v[pos] then 
        pos:=j;
    end;

    item:=v[i];
    v[i]:=v[pos];
    v[pos]:=item;
  end;
end;

procedure busquedaDicotomica (v:vector;ini,fin: integer; dato:integer; var pos:integer);
var 
  medio:integer;
begin
  medio:=(ini+fin) div 2;

  if (ini<=fin) then 
  begin 
  writeln('ini: ',ini,' fin: ',fin,' N: ',dato,' pos: ',pos,' Medio:',medio);
    if (v[medio]=dato) then 
        pos:=medio
    else 
      if (v[medio]>dato) then 
        busquedaDicotomica(v,ini,medio-1,dato,pos)
      else
        busquedaDicotomica(v,medio+1,fin,dato,pos);
  end 
  else 
      pos:=-1;
end;

var
  v:vector;
  dimL,i:integer;
  pos,num:integer;
begin
  i:=1;
  dimL:=dimF;
  v:=cargarRecursivo(v,i);
  imprimirRecursivo(v,i);
  ordenarVector(v,dimL);
  writeln('--------------------------');
  imprimirRecursivo(v,i);

  write('numero a buscar: ');
  readln(num);
  
  busquedaDicotomica (v,1,dimL,num,pos);
  if(pos = -1)then
    writeln('el numero no esta en el vector')
  else
    writeln('el numero si esta en el vector');
end.