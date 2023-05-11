package com.example.gestionAdherents.utils;

public final class SizeMapper {

    public SizeMapper(){
        super();
    }
    public final class SizePrenom {
        public SizePrenom(){
            super();
        }
        public static final int MIN=2;
        public static final int MAX=20;
    }
    public final class SizeNom {
        public SizeNom(){
            super();
        }
        public static final int MIN=2;
        public static final int MAX=10;
    }
    public static final class SizeMapperPassword{
        private SizeMapperPassword(){super();}
        public static final int MIN=8;
        public static final int MAX=12;
    }
    public static final class SizeMapperSecurity{
        private SizeMapperSecurity(){super();}
        public static final int MIN=7;
    }
    public static final int LENGTH=32;
    public static final int MIN=14;
    public static final int MINCO=500;
    public static final int MAXCO=5000000;
}
