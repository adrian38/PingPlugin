export interface PingPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
