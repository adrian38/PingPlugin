// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "PingPlugin",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "PingPlugin",
            targets: ["PingPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "PingPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/PingPluginPlugin"),
        .testTarget(
            name: "PingPluginPluginTests",
            dependencies: ["PingPluginPlugin"],
            path: "ios/Tests/PingPluginPluginTests")
    ]
)