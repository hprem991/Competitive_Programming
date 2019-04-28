class Point {
        int x,y; `
};


bool doOverLap(Point l1, Point r1, Point l2, Point r2){
   if((l1.x > r2.x) || (l2.x > r1.x)) return false;
   if((l1.y > r2.y) || (l2.y > r2.y)) return false;
   return true;
}
~                 
