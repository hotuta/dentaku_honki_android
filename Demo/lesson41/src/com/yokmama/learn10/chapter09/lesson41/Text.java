package com.yokmama.learn10.chapter09.lesson41;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

/**
 * テキスト
 *
 * Created by kayo on 6/3/15.
 */
class Text {

    private final GlyphLayout glyphLayout;
    private float vpWidth = MyGdxGame.VIEWPORT_WIDTH;
    private float vpHeight = MyGdxGame.VIEWPORT_HEIGHT;
    private final BitmapFont font;

    public Text(BitmapFont font) {
        this.font = font;
        glyphLayout = new GlyphLayout();
    }

    // 上部にテキストを描画
    public void drawTextTop(Batch batch, String text) {
        glyphLayout.setText(font, text, Color.WHITE, 0, Align.center, false);
        font.draw(batch, glyphLayout,
                vpWidth * 0.5f, vpHeight - glyphLayout.height * 1.5f);
    }

    // 中央にテキストを描画
    public void drawTextCenter(Batch batch, String text) {
        glyphLayout.setText(font, text, Color.WHITE, 0, Align.center, false);
        font.draw(batch, glyphLayout,
                vpWidth * 0.5f, vpHeight * 0.5f + glyphLayout.height * 0.5f);
    }

    // スコアアイテム取得時のテキスト描画
    public void drawChipScore(Batch batch, String text, Color color, float scaleXY, float x, float y) {
        glyphLayout.setText(font, text, color, 0, Align.left, false);
        font.getData().setScale(scaleXY);
        font.draw(batch, glyphLayout, x, y);
        font.getData().setScale(1.0f);
    }

}
