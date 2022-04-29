package com.example.tcc_after.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import kotlin.jvm.internal.Intrinsics;

public class imagemConversao {

    public static final String convertToBitmapToBase64(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        ByteArrayOutputStream bitmapArray = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)bitmapArray);
        byte[] byteArray = bitmapArray.toByteArray();
        String var10000 = Base64.encodeToString(byteArray, 0);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "Base64.encodeToString(byteArray, Base64.DEFAULT)");
        return var10000;
    }

    public static final Bitmap convertBase64ToBitmap(String base64image) {
        Intrinsics.checkParameterIsNotNull(base64image, "base64image");
        byte[] imageBit = Base64.decode(base64image, 0);
        Bitmap var10000 = BitmapFactory.decodeByteArray(imageBit, 0, imageBit.length);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "BitmapFactory.decodeByte…ageBit, 0, imageBit.size)");
        return var10000;
    }
}
