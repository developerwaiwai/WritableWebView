//
//  ViewController.m
//  sample
//
//  Created by Android on 12/11/29.
//  Copyright (c) 2012年 Android. All rights reserved.
//

#import "ViewController.h"
#import "WritableView.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    [__webView loadRequest:[NSURLRequest requestWithURL:[NSURL URLWithString:@"http://developerwaiwai.blogspot.jp/"]]];
    WritableView* writableView = [[WritableView alloc] initWithFrame:[__webView.superview frame]];
    [__webView.superview addSubview:writableView];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
