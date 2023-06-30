package com.ict.cloud.image;

import com.ict.cloud.authentication.Authenticated;
import com.ict.cloud.common.Client;
import com.ict.cloud.image.api.ImageManager;
import com.ict.cloud.image.api.v2.Images;


public class Image extends Client {
    public final ImageManager images;
    public Image(Authenticated credentical) {
        super(credentical);
        images = new Images(credentical);
    }
}
