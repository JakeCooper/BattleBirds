package com.wow.battlebirds.engine.entity.collision;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.wow.battlebirds.engine.entity.Entity;

/**
 * Package com.wow.battlebirds.engine.entity.collision
 * Created by ChrisH on 07/03/14.
 *
 * Utility class for handling intersection checks between entities.
 */
public class CollisionDetector {

    // Pixel perfect implementation of collision detection.
    // Optimized by only checking overlapping area between bounding rectangles,
    // and checks that overlapping pixels are not transparent.
    public static boolean isCollidedWith(Entity one, Entity two)
    {
        BoundingRectangle b1 = one.getBounds();
        BoundingRectangle b2 = two.getBounds();

        if(b1.intersects(b2))
        {
            // Retrieve area of overlap between the bounding boxes
            BoundingRectangle area = getCollisionBounds(b1, b2);

            // Get reference to the bitmaps of the two entities
            Bitmap bit1 = one.asset.image.getBitmap();
            Bitmap bit2 = two.asset.image.getBitmap();

            // Iterate each x,y pixel of the overlapping bounding area
            for(int i = area.getMinimum().x; i < area.getMaximum().x; i++)
            {
                for(int j = area.getMinimum().y; j < area.getMaximum().y; j++)
                {
                    // Retrieve pixel reference from both bitmaps that are overlapping
                    int pixel1 = bit1.getPixel(i - area.getMinimum().x, i - area.getMinimum().y);
                    int pixel2 = bit2.getPixel(j - area.getMaximum().x, j - area.getMaximum().y);

                    // If neither pixel is transparent, we have a legitimate intersection
                     if(!isPixelTransparent(pixel1) && !isPixelTransparent(pixel2))
                        return true;
                }
            }
        }

        return false;
    }

    // Calculate the overlap between two rectangular bounds and return the bounds of the overlap
    public static BoundingRectangle getCollisionBounds(BoundingRectangle one, BoundingRectangle two)
    {
        int minX = Math.max(one.getMinimum().x, two.getMinimum().x);
        int minY = Math.max(one.getMinimum().y, two.getMinimum().y);
        int maxX = Math.min(one.getMaximum().x, two.getMaximum().x);
        int maxY = Math.min(one.getMaximum().y, two.getMaximum().y);

        return new BoundingRectangle(minX, minY, maxX, maxY);
    }

    public static boolean isPixelTransparent(int pixel)
    {
        return pixel == Color.TRANSPARENT;
    }

}
