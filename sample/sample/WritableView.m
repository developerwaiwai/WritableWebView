//
//  WritableView.m
//  sample
//
//  Created by Android on 12/11/29.
//  Copyright (c) 2012年 Android. All rights reserved.
//

#import "WritableView.h"

@implementation WritableView

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
        
        self.opaque = YES;
        self.backgroundColor = [UIColor colorWithWhite:1.0f alpha:0.0f];
        self.autoresizesSubviews = YES;
        self.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
        self.contentMode = UIViewContentModeScaleToFill;
        
        _path = [UIBezierPath bezierPath];
        _path.lineCapStyle = kCGLineCapRound;
        _path.lineJoinStyle = kCGLineJoinRound;
    }
    return self;
}


- (void)touchesBegan:(NSSet*)touches withEvent:(UIEvent*)event
{
    UITouch* touch = [[event touchesForView:self] anyObject];
    CGPoint touchedLocation = [touch locationInView:self];
    
    [_path removeAllPoints];
    [_path moveToPoint:touchedLocation];
    
}


- (void)touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{
    UITouch* touch = [[event touchesForView:self] anyObject];
    CGPoint movedLocation = [touch locationInView:self];
    
    [_path addLineToPoint:movedLocation];
    [self setNeedsDisplay];
}


- (void)touchesEnded:(NSSet*)touches withEvent:(UIEvent*)event
{
    [self setNeedsDisplay];
}


- (void)drawRect:(CGRect)rect
{
    [[UIColor redColor] setStroke];
    _path.lineWidth = 5;
    
    CGContextSetShouldAntialias(UIGraphicsGetCurrentContext(), YES);
    [_path stroke];
}


@end
