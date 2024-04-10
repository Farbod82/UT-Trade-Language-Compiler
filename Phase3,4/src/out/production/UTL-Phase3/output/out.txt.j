.class public UTL 
.super java/lang/Object
.field public balance Ljava/lang/Integer;
.field public tick_counts Ljava/lang/Integer;
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		putfield UTL/tick_counts:Ljava/lang/Integer;
.method public <init>()V
		aload_0
		invokespecial java/lang/Object/<init>()V
.end method
.method public far(Ljava/lang/Integer;)Ljava/lang/Void;
.limit stack 128
.limit locals 128
		ldc "SELL"
		ldc 100
		ldc 100
		ldc 10
		invokevirtual Order(nullLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)LUTL/Order
		store_2
.end method
